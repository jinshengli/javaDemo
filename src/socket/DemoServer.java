package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DemoServer extends Thread {

    private ServerSocket serverSocket;

    private  static ExecutorService pool =  Executors.newFixedThreadPool(8);

    public int getPort(){
        return serverSocket.getLocalPort();
    }


    public void run(){
        try {
            serverSocket = new ServerSocket(0);
            while (true){
                Socket accept = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(accept);
                pool.execute(requestHandler);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
           if (serverSocket != null ){
               try {
                   serverSocket.close();
               }catch (IOException e){
                   e.printStackTrace();
               }
           }
        }

    }

    public static void main(String[] args) {
        DemoServer server = new DemoServer();
        server.start();

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), server.getPort());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class RequestHandler extends Thread {

    private Socket socket;
    RequestHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("hello world");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer extends Thread {

    public void run(){
        try(
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open() ){
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectionKeys.iterator();
                while ( iter.hasNext() ){
                    SelectionKey key = iter.next();
                    sayHelloWorld((ServerSocketChannel) key.channel());
                    iter.remove();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel serverSocketChannel){
        try {
            SocketChannel accept = serverSocketChannel.accept();
            accept.write(Charset.defaultCharset().encode("Hello world!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        NIOServer server = new NIOServer();
        server.start();

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

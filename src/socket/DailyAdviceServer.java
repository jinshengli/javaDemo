package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * create by ljs on 2020/6/26 20:35
 * <p>
 * description:
 */
public class DailyAdviceServer {

    private String[] adviceString = {
            "在吗", "你在", "额美俄米"
    };


    public void go() {


        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            while ( true ) {

                Socket accept = serverSocket.accept();
                OutputStream outputStream =
                        accept.getOutputStream();

                OutputStreamWriter outputStreamWriter =
                        new OutputStreamWriter(outputStream);

                PrintWriter writer = new PrintWriter(outputStreamWriter);
                String advice = getAdvice();
                writer.print(advice);
                writer.close();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceString.length);
        String s = adviceString[random];
        return s;
    }

    public static void main(String[] args) {

        DailyAdviceServer dailyAdviceServer = new DailyAdviceServer();
        dailyAdviceServer.go();

    }


}

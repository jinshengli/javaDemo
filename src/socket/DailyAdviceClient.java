package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * create by ljs on 2020/6/26 20:18
 * <p>
 * description: socket客户端； 读取刘教授的建议。
 */
public class DailyAdviceClient {


    public void go() {

        try {

            Socket socket = new Socket("127.0.0.1", 5000);
            InputStream inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream); // 字节转换成字符；
            BufferedReader reader = new BufferedReader(inputStreamReader); // 字符缓冲流
            String s = reader.readLine();  // 读取一行数据。

            System.out.println("刘教授的advice: " + s);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        DailyAdviceClient dailyAdviceClient = new DailyAdviceClient();
        dailyAdviceClient.go();

    }


}

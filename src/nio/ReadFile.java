package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFile {


    public static void main(String[] args) throws IOException {


        FileInputStream fileInputStream = new FileInputStream("my.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);


        int read = channel.read(buffer);

        buffer.flip();

        while ( buffer.remaining() > 0 ){
            byte b = buffer.get();
            System.out.println("char = " + (char)b);
        }

        fileInputStream.close();




    }

}

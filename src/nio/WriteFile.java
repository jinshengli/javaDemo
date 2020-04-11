package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class WriteFile {

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byte []message = {'I','R','E','F'};

        for (int i=0; i < message.length; ++i ){
            byteBuffer.put(message[i]);
        }
        byteBuffer.flip();

        int write = channel.write(byteBuffer);


    }


}

package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {


    public static void copy(String originFile, String destFile) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(originFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        FileChannel channel = fileInputStream.getChannel();
        FileChannel channel1 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true){
            byteBuffer.clear();
            int read = channel.read(byteBuffer);
            if ( read == -1 )
                break;
            byteBuffer.flip();
            channel1.write(byteBuffer);
        }


    }


    public static void main(String[] args) throws IOException {

        copy("my.txt","mm.txt");



    }


}

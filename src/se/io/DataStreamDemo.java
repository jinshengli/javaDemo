package se.io;

import java.io.*;
import java.util.Arrays;

public class DataStreamDemo {


    public static void main(String[] args) throws IOException {

        File file = new File("test.dat");
        Long data = 1000L;

        if ( file.exists() ){
            InputStream inputStream = new FileInputStream("test.dat");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            data = dataInputStream.readLong();
            System.out.println(data);
            data  = data + 1;
        }

        DataOutputStream dot = new DataOutputStream( new FileOutputStream("test.dat"));
        dot.writeLong(data);


    }


}

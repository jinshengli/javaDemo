package io;

import java.io.*;

public class InputStreamDemo {

    public static void main(String[] args) throws IOException {


       // 抽象类

       FileInputStream fileInputStream = new FileInputStream("mm.txt");


        System.out.println(fileInputStream.available());

        int read = fileInputStream.read();

        System.out.println(fileInputStream.available());

//        InputStream

//        FilterInputStream

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);




    }


}

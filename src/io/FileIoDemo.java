package io;

import java.io.*;


public class FileIoDemo {

    public static void main(String[] args) throws IOException {


        File file = new File("src/io/file.txt");

        if ( !file.exists()) {
            file.createNewFile();
        }

        // 操作文件的 字节输入流
        FileOutputStream outputStream = new FileOutputStream(file);

        for ( int i = 0; i < 10; ++i ) {
            String s = "zs什么" + i + '\n';
            byte[] bytes = s.getBytes();
            outputStream.write(bytes);
        }

        outputStream.close();

        // 字节输入流
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[20];
        while ( inputStream.read(bytes) != -1 ) {
            String st = new String(bytes);
            System.out.println(st);
        }

        /**
         *  下面是 Writer/Reader 操作文件。
         */
        FileWriter fileWriter = new FileWriter(file, true);

        for ( int i = 0 ; i < 5; ++i ) {
            fileWriter.write("writer: " + i );
        }

        fileWriter.close();
        FileReader fileReader = new FileReader(file);


        String s="";
        char []chars = new char[100];

        while ( fileReader.read(chars) != -1 ) {
            System.out.println(chars);
        }




    }


}

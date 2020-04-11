package se.io;

import java.io.*;
import java.util.Arrays;

public class FileInputOutPutDemo {


     static void outPutStream(FileOutputStream fileOutputStream) throws IOException {

        String msg = "hello world";

        byte[] bytes = msg.getBytes();

        fileOutputStream.write(bytes);


    }

     static void inPutStream(FileInputStream fileInputStream) throws IOException {

         byte[] bytes = new byte[20];

         fileInputStream.read(bytes);

         System.out.println(Arrays.toString(bytes));

     }


    public static void main(String[] args) {

//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream("text.txt", true);
//            outPutStream(fileOutputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            fileOutputStream.close();
//        }

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("text.txt");
            inPutStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }


    }


}

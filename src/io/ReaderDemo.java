package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * create by ljs on 2020/5/26 17:07
 *
 *
 * 以字符为单位的形式操作数据。
 *
 */
public class ReaderDemo {


    public static void readFileContent(String path) throws IOException {


        FileReader fileReader = new FileReader(path);

        BufferedReader reader = new BufferedReader(fileReader);

        String line;

        while ( (line = reader.readLine() ) != null ){

            System.out.println(line);

        }


    }

    public static void main(String[] args) throws IOException {

        ReaderDemo.readFileContent("mm.txt");


    }



}

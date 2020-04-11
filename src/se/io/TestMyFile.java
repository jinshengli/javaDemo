package se.io;

import java.io.File;


class TestMyFile{
    public static void main(String args[]) throws Exception{
        File file;
        //创建一个 File 对象表示当前目录下的“hello.txt”文件

//        file = new File(".");
//        System.out.println(file.getAbsolutePath());

        file = new File("hello.txt");


        //判断该文件是否存在
        //如果该文件存在，则输出该文件的完整路径

        if ( file.exists() ){
            System.out.println(file.getAbsolutePath());
        }
    }
}
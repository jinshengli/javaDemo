package se.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {


    public static void main(String[] args) throws IOException {


        File file = new File("ooo.txt");

        System.out.println(file.getPath());

        System.out.println(file.getAbsolutePath());

        file.isDirectory();

        file.createNewFile();

    }
}

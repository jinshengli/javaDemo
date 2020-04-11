package se.stringdemo;

import java.util.Random;

public class RandomStringDemo {

    public static void main(String[] args) {

        String str = "ABCDEFGhijklmn1234567";

        char[] chars = str.toCharArray();

        Random random = new Random();

       StringBuilder stringBuilder = new StringBuilder();

        for ( int index = 0; index < 4; ++index ){
            int i = random.nextInt(100);
            stringBuilder.append(chars[i%chars.length]);
        }

        System.out.println(stringBuilder);


    }

}

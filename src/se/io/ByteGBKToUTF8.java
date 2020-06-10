package se.io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ByteGBKToUTF8 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        byte[] src = "wowow".getBytes(Charset.forName("GBK"));

        byte[] dst;

        dst = new String(src, "UTF-8").getBytes();

        System.out.println(dst);

        double d=5.3e12;

        float f=11.1f;

//        int i=0.0;
//
//
//        Double oD=3;



    }

}

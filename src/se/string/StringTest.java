package se.string;

import java.util.ArrayList;

/**
 * 如果不是用双引号声明的String对象,可以使用 String 提供的 intern 方法。
 * String.intern() 是一个 Native 方法，它的作用是：
 * 如果运行时常量池中已经包含一个等于此 String 对象内容的字符串，则返回常量池中该字符串的引用；
 * 如果没有，则在常量池中创建与此 String 内容相同的字符串，并返回常量池中创建的字符串的引用。
 */

public class StringTest {

    public static void main(String[] args) {

        String s = new String("aaa");

        String const_s = s.intern();

        String st = "aaa";

        System.out.println(s == st );
        System.out.println( const_s == st );

        StringBuffer stringBuffer = new StringBuffer();

        String a = new String();





        StringBuilder stringBuilder = new StringBuilder();

        /**
         *  用final 修饰基本类型，内容是不能变化的。
         */

        final char wp[] = new char[10];

        wp[0] = '2';
        wp[1] = '1';

        final char[] ei = {'q','v','x'};
//        ei[0] = 'dds';

        float l = 21.3f;



        int i = (int) l;

        System.out.println(i);



        final ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(102);

        byte p = 100;
        byte o = 127;

        /**
         * byte类型的变量在做运算时被会转换为int类型的值，故A、B左为byte，右为int，会报错；
         * 而C、D语句中用的是a+=b的语句，此语句会将被赋值的变量自动强制转化为相对应的类型。
         *
         * b=(byte)(a+b)
         */

        // o = p + o;// require byte, found int

        p = (byte) (o + p);
        System.out.println(p);
        p += o;
        System.out.println("p = " + p);

        if ( new Integer(1) instanceof Integer ){
            System.out.println("yes");
        }


    }

}

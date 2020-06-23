package se.string;

/**
 * create by ljs on 2020/6/23 14:10
 * <p>
 * description:
 *      判断字符串：
 *      1）字符串是否是同一字符串
 *           == 是否是同一引用，是使用常量池中的同一引用、
 *
 *      2）字符串是否相等
 *          equal 值是否相等、
 *
 */
public class StringEqualOrRefSame {


    public static void main(String[] args) {

        String a = new String("ab");

//        System.out.println(a.intern());

        String b = new String("ab");


        String ab = "ab";
        String ac = "ab";

        char[] wo = new char[2];
        wo[0] = 'a';
        wo[1] = 'b';

        String aa = String.valueOf(wo); // new String(char[])

        System.out.println(aa == ab);  //false

        System.out.println(a == b );  // false

        System.out.println( ab == a ); // false

        System.out.println( ab == ac ); // true

    }


}

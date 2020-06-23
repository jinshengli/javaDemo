package se.string;


/**
] * String.intern() 是一个 Native 方法，它的作用是：
 * 如果运行时常量池中已经包含一个等于此 String 对象内容的字符串，则返回常量池中该字符串的引用；
 * 如果没有，则在常量池中创建与此 String 内容相同的字符串，并返回常量池中创建的字符串的引用。
 */

public class StringTest {

    public static void main(String[] args) {

        String s = new String("aaa");
        String const_s = s.intern();
        System.out.println(const_s); // aaa
        String st = "aaa";
        System.out.println(s == st ); // false
        System.out.println( const_s == st ); // true
        System.out.println(const_s == s); // false  ****

    }

}

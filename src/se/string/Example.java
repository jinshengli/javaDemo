package se.string;

/**
 * create by ljs on 2020/5/6 7:25
 *
 * 注意：
 *  String 作为参数传递，会影响它的实参吗？
 *  不会的，因为实参和形参在栈上的值不一样，指向的字符串不一样。修改形参不影响实参。
 *
 *
 */


public class Example {

    String str = new String("goood");
    char []ch = {'a','b','c'};

    public static void main(String[] args) {
        Example example = new Example();

        example.change(example.str, example.ch);

        // String 底层是final修饰的，不可修改的。表现出来和值传递一样的效果。
        System.out.println(example.str);  // example.str 指堆中一个新的字符串 【值传递】
        System.out.println(example.ch);  // example.ch 引用传递。

        example.change(example);

        System.out.println("after");

        System.out.println(example.str);
        System.out.println(example.ch);


    }

    private void change(Example example) {
        example.str = "wowowo";
        example.ch[0] = 's';
    }

    private void change(String str, char[] ch) {
        str  = "xxxx";
        ch[0] = 'g';
    }

}

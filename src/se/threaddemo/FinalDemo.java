package se.threaddemo;

public class FinalDemo {


    public static void changeValue(final int i){
//        i ++;
        System.out.println(i);
    }

    public static void changeString(final StringBuilder stringBuilder){
        stringBuilder.append("aaa");
//        stringBuilder = new StringBuilder();

    }


    public static void main(String[] args) {

        String a = "wukong2";

        final String b = "wukong";

        String d = "wukong";

        String c = b + 2;

        String e = d + 2;

        System.out.println(b == d );

        System.out.println(a == c );

        System.out.println(a == e );

        changeValue(10);











    }


}

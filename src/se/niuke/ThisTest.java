package se.niuke;

public class ThisTest {


    public static void main(String args[]) {
        String x="7";
        int y = 2;
        int z=2;


        System.out.println(x+y+z);


        String s = "祝你考出好成绩！";
        System.out.println(s.length());


        Integer integer = new Integer(12);

        Integer integer1 = new Integer(23);

        System.out.println(integer == integer1);



        String classFile = "com.jd.".replaceAll("\\.", "/") + "MyClass.class";
        System.out.println(classFile);


//        a = Integer.parseInt("1024");
//
//        b = Integer.valueOf("1024").intValue();


        System.out.println("   abcd  ".trim() == "abcd");

        String a = "abcd";

        System.out.println( a == "abcd");


        String sq = new String("abcd");

        System.out.println(a == sq );

        System.out.println( sq == "abcd");

    }


}

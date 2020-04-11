package se.chp08;

public class StringToInt {


    public static void main(String[] args) {

        String p = "1234";

        int i = Integer.parseInt("12321");
        System.out.println(i);

        Integer integer = new Integer(p);
        int i1 = integer.intValue();

        System.out.println(i1);


    }

}

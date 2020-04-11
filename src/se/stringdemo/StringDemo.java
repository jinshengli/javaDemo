package se.stringdemo;

public class StringDemo {

    public static void main(String[] args) {

        String email = "zhengcg@zparkhr.com";


        String userName = email.substring(0, email.indexOf('@'));

        System.out.println(userName);

        if ( email.indexOf('@') != -1 && email.indexOf('.') != -1 ){

            if (email.indexOf('@') < email.indexOf('.')){
                System.out.println("邮箱合法");
            }
        }
    }

}

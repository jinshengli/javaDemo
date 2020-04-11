package se.stringdemo;

public class CharacterCount {


    public static void main(String[] args) {


        String str = "1239586838923173478943890234092";

        int ans[] = new int[10];

        for ( int i=0; i < str.length(); ++i ){
            int index = str.charAt(i) - '0';
            ans[index] ++ ;

        }

        for (int i=0; i < ans.length; ++i )
            System.out.println(ans[i]);

    }

}

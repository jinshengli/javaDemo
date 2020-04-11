import java.io.File;

public class TestApp {

    public static boolean reverser(String s){
        StringBuilder stringBuilder  = new StringBuilder(s);
        return stringBuilder.reverse().toString().equals(s);
    }

    public static void main(String[] args) {

    }
}
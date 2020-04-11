package myLetest;

public class Da {

    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
        System.out.print(Integer.MAX_VALUE*2);
        System.out.print(Integer.MIN_VALUE*2);
    }
    static void pong() {
        System.out.print("pong");
    }


}

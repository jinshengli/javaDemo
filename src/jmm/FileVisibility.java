package jmm;

/**
 *  可见性问题
 */

public class FileVisibility {

    volatile int a = 1;
    volatile int b = 2;

    public static void main(String[] args) {

        while (true){
            FileVisibility test = new FileVisibility();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();


        }




    }

    private void print() {
        if ( a==3 && b == 2)
        System.out.println("a = " + a + " b=" + b);
    }

    private void change() {
        a = 3;
        b = a;
    }


}

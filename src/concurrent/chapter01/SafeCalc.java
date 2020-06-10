package concurrent.chapter01;

public class SafeCalc {

    long value = 0;

    synchronized long getValue(){
        return value;
    }

    synchronized void addOne(){
        value += 1;
    }
}

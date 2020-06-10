package se.extend;

/**
 * create by ljs on 2020/5/6 8:24
 */
public class TestDemo{
    private int count;
    public static void main(String[] args) {
        TestDemo test=new TestDemo(88);
        System.out.println(test.count);
    }
    TestDemo(int a) {
        count=a;
    }
}

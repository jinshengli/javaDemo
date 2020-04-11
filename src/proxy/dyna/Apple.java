package proxy.dyna;

public class Apple implements Fruit{
    @Override
    public void show() {
        System.out.println("show method is invoke");
    }

    @Override
    public void love() {
        System.out.println("I love fruit");
    }
}

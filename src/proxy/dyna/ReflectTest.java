package proxy.dyna;

public class ReflectTest {

    public static void main(String[] args) {
        Fruit fruit = (Fruit) DynamicAge.agent(Fruit.class, new Apple());
        fruit.show();
        fruit.love();
    }
}

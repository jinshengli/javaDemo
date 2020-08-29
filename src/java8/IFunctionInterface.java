package java8;

@FunctionalInterface
public interface IFunctionInterface {
    public void run();

    default void sd() {
        System.out.println("ddd");
    }

}

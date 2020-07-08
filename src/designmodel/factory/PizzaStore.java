package designmodel.factory;

/**
 * create by ljs on 2020/7/8 9:45
 * description:  披萨店的超类。
 *
 *
 *  createPizza(String type) 抽象方法，封装pizza对象的创建，为工厂方法。
 *  由子类去决定如何创建pizza.
 *
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {

        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;

    }

    abstract Pizza createPizza(String type);


}

package designmodel.factory;

/**
 * create by ljs on 2020/7/8 10:31
 * description:  定义一个原料工厂接口，该接口负责创建所有的原料家族。
 *
 *
 *
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();

}

class Dough{

}

class Sauce{

}

class Cheese{

}

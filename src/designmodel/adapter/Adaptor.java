package designmodel.adapter;


/**
 *   类适配器：基于继承。
 *
 *   如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都相同，那我们推
 *   荐使用类适配器，
 *
     因为 Adaptor 复用父类 Adaptee 的接口，比起对象适配器的实现方式，Adaptor 的代码量要少一些
 *
 */

public class Adaptor extends Adaptee implements ITarget {
    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        // .... 重新实现f2() ....
    }

    // 这里fc()不需要实现，直接继承Adaptee， 这是和对象适配器不同的地方。


}

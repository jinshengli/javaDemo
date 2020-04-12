package designmodel.adapter;


/**
 *  对象适配器， 实现 委托Adaptee 对象来实现 ITarget 接口。
 *
 *  如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都不相同，那我们
 * 推荐使用对象适配器，因为组合结构相对于继承更加灵活
 */

public class AdaptorByInterface implements ITarget{

    private Adaptee adaptee;

    public AdaptorByInterface(Adaptee adaptee){
        this.adaptee = adaptee;
    }


    @Override
    public void f1() {
        adaptee.fa();  // 委托给adaptee 实现。
    }

    @Override
    public void f2() {
        // 重新实现 f2;
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}

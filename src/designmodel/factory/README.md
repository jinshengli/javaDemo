

#### 工厂模式

    封装对象的创建，针对对象创建过程复杂，依赖过多，变化可能性大。
    封装对象的创建过程，实现对象的创建和使用解耦，增大可维护性。



##### 简单工厂
    
    按理说不是设计模式，也常用，就是将对象的创建封装到一个类中。
    通过这个工厂创建对象。



##### 工厂方法

    工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂
    方法让类把实例化推迟到子类
    
    
    类似first head 设计模式中，定义了抽象的比萨店，其中有个创建比萨的抽象方法是工厂方法。
    实例化对象的职责被转移到一个方法中，该方法好像一个工厂。


##### 抽象工厂模式

    抽象工厂模式提供一个接口，用户创建相关或依赖对象的家族，不需要明确指定具体类。
    
    first head 设计模式中，引入了比萨制作的原料工厂，不同地区的有各种不同的原料。为了创建这些
    原料家族对象，我们使用抽象工厂模式，每个地区工厂创建符合该地区口味的原料【族】。



##### 思考

    1. 抽象工厂模式和抽象方法模式有点像，抽象工厂中类似定义了一组抽象方法。
    
    2. 工厂模式都首先定义一个接口或抽象类，好处，客户可以依赖抽象，而不是依赖具体。
        无论是使用哪个工厂创建对象，还是创建哪种类型的对象，都是依赖抽象，而不是具体。









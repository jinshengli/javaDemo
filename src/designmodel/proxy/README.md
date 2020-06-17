#### 动态代理

##### JDK的动态代理

实现jdk动态代理：使用jdk中的类实现动态代理的功能

1. 接口，定义功能接口
2. 创建目标类，实现接口
3. 创建调用处理器，实现了InvocationHandler接口的类
   重写接口中的方法，实现代理类要做的工作。
        
       1）目标方法调用
       2）功能增强

4. 创建代理对象，使用Proxy工厂实现代理对象的创建。

        创建代理对象需要的原材料：
        1. 接口，功能接口，目标类实现的接口
        2. 目标类，知道目标类，才能创建这个目标类的代理
        3. InvocationHandler接口实现类


### 实践步骤


#### 1） 通过Proxy类的静态方法newProxyInstance(...) 创建代理对象，

     public static Object newProxyInstance(ClassLoader loader,
                                              Class<?>[] interfaces,
                                              InvocationHandler h)
                                              
                                              
     方法参数：
     1，目标对象的类加载器，需要的是ClassLoader类型，通过反射就能获取。
     2. 目标对象实现的接口，通过反射也能获取；【interfaces参数是该动态类所继承的所有接口】
        指定动态代理类所继承的接口。
     3. InvocationHandler对象。   


                                              
#### 2）实现InvocationHandler接口，对目标方法增强。【处理器】

   1，通过它执行目标方法
   2，增强功能
    
   需要重写invoke方法
   
   成员变量：被代理对象。作用：调用目标方法。
   
    public Object invoke( Object proxy, Method method, Object[] args )
    
    方法参数：参数通过反射得来
        1. Object proxy: jdk创建代理对象，一般不使用
        2. Method method: 需要代理的方法。
        3. Object args: 代理方法的参数。
        
    proxy.say("I love u")  ==>  InvocationHanlder对象.invoke(“say”, args);
    
    
#### 最终代理类的形态是怎么样的呢？

代理类 $Proxy0 继承了Proxy类，实现了被代理的接口。

        
    
    
    
    

    


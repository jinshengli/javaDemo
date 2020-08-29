### java 8 新特性


####1 方法参数行为化

特点： （类似策略模式）

    传递代码，就是将新行为作为参数传递给方法
    
    行为参数化，就是一个方法接受多个不同的行为作为参数，并在内部使用它们，完成不
    同行为的能力。
    
    行为参数化可让代码更好地适应不断变化的要求，减轻未来的工作量。


代码例子：
    
    //  lamda 表达式完成  行为参数化。
    List<Apple> redApples =
    filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    
    // Comparator 排序  用Lambda表达式的话
    inventory.sort((Apple a, Apple b) -> a.getWeight().compareTo(b.getWeight()) );
    
    
    // Runnable 接口；
        new Thread(()-> System.out.println("这个是Lamda表达式运行的")).start();
        
#### 什么是Lambda表达式

理解：简洁地表示可传递的匿名函数的一种方式;
 
特点：
    1. 匿名；没用名称
    2. 函数：lambda表达式它不属于特定的类，但是和方法一样; 返回值，参数列表，函数体，抛出异常
    3. 传递： lambda表达式可作为参数传递给方法。
    4. 简洁
    
    格式：
    (parameters) -> expression
    (parameters) -> { statements; }
    
#### 什么是函数式接口

函数式接口就是只定义一个抽象方法的接口     

lambda表达式可以为函数式接口提供完美地实现。并把整个表达式作为函数式接口的实例

@FunctionalInterface代表的是给接口一定需要被设计成 函数式接口；
否者编译器报错。


    @FunctionalInterface
     public interface IFunctionInterface {
         public void run();
     }
         

列子：
    
Consumer 函数式接口

java.util.function.Consumer<T> 定义了一个名叫 accept 的抽象方法，它接受泛型 T
的对象，没有返回（ void ）。你如果需要访问类型 T 的对象，并对其执行某些操作，就可以使用
这个接口。

Function 函数式接口

java.util.function.Function<T, R> 接口定义了一个叫作 apply 的方法，它接受一个
泛型 T 的对象，并返回一个泛型 R 的对象。

    @FunctionalInterface
    public interface Function<T, R>{
    R apply(T t);
    }

#### 什么叫方法引用
     
     可视为某些Lambda的快捷写法。
     方法引用让你可以重复使用现有的方法定义，并像Lambda一样传递它们
     
    当你需要使用方法引用时，目标引用放在分隔符 :: 前，方法的名称放在后面
    
    Apple::getWeight 就是引用了 Apple 类中定义的方法 getWeight 。     
     
     
#### 引入流

 java.util.stream.Stream
 
 stream() ----- 将序列转成流
 filter   ----- 接受一个Lambda，从流中排除某些元素
 map      ----- 接受一个Lambda, 将元素转换成其他形式或提出信息
 limit    ----- 截断流，使其元素不超过给定元素
 collect  ----- 将流转换为其他形式。  collect 触发流水线执行并关闭它。
 
 
4.4.3 使用流
总而言之，流的使用一般包括三件事：
  一个数据源（如集合）来执行一个查询；
  一个中间操作链，形成一条流的流水线；
  一个终端操作，执行流水线，并能生成结果  
     

#### 中间操作

    操 作    返回类型      操作参数        函数描述符
    filter  Stream<T>  Predicate<T>    T -> boolean
    map     Stream<R>  Function<T, R>  T -> R
    limit   Stream<T>
    sorted  Stream<T>  Comparator<T>  (T, T) -> int
    distinct Stream<T> 
         
#### 终端操作
    forEach
    终端  消费流中的每个元素并对其应用 Lambda。这一操作返回 void
    count
    终端  返回流中元素的个数。这一操作返回 long
    collect
    终端  把流归约成一个集合，比如 List 、 Map 甚至是 Integer         
     
#### 使用流
     
#### 筛选和切片
     
     用谓词筛选
     
     filter 接受一个返回boolean的函数。
     
     筛选各异的元素
     流还支持一个叫作 distinct 的方法，它会返回一个元素各异（根据流所生成元素的
     hashCode 和 equals 方法实现）的流。 
     
#### 映射

      一个非常常见的数据处理套路就是从某些对象中选择信息
 
 1、对流中每一个元素应用函数
  
    map
 
 2. 流的扁平化
             
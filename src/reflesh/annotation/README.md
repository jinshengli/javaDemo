
### 注解

    Java的注解本身对代码逻辑没有任何影响。
    SOURCE类型的注解在编译期就被丢掉了；
    CLASS类型的注解仅保存在class文件中，它们不会被加载进JVM；
    RUNTIME类型的注解会被加载进JVM，并且在运行期可以被程序读取。

因为注解定义后也是一种class，所有的注解都继承自java.lang.annotation.Annotation，
因此，读取注解，需要使用反射API。


#### 元注解

java标准库已经定义了一些元注解，用来修饰其他注解。

###### @Target 可以定义Annotation能够被应用于源码的哪些位置：

1. 类或接口： ElementType.TYPE
2. 字段：ElementType.FIELD
3. 方法: EleEmentType.METHOD
4. 构造方法: ElementType.CONSTRUCT
5. 方法参数: ElementType.PARAMETER


@Target 定义的value 是一个ElementType 数组


##### @Retention 定义了Annotation的生命周期

    1. 仅编译期：RetentionPolicy.SOURCE
    2. 仅class文件： RetentionPolicy.CLASS
    3. 运行期：RetentionPolicy.RUNTIME
默认是CLASS, 我们自定义都是RUNTIME


##### @Repeatable 定义注解是否可重复，不是特别广泛



##### @Inherited

使用@Inherited定义子类是否可继承父类定义的Annotation。
@Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，并且仅针对class的继承，对interface的继承无效：



##############################


## 如何定义Annotation

#### 1. 用@interface定义注解

    public @interface Report {
        
    }
    
#### 2. 添加参数，默认值
    
    public @interface Report {
        int type() default 0;
        String level() default "info";
        String value() default "";
    }
    
    常用的参数定义为value(), 推荐所有的参数设置默认值
    核心参数使用value名称；

#### 3. 用元注解配置注解

     @Target(ElementType.TYPE)
     @Retention(RetentionPolicy.RUNTIME)
     public @interface Report {
            int type() default 0;
            String level() default "info";
            String value() default "";
     }
     
     规定：必须设置@Target 和 @Retention, @Retention 一般为Runtime
     
## 如何使用注解

定义了注解，本身对程序逻辑没有任何影响。我们必须自己编写代码来使用注解。

判断某个注解是否存在于Class、Field、Method或Constructor：

    Class.isAnnotationPresent(Class)
    Field.isAnnotationPresent(Class)
    Method.isAnnotationPresent(Class)
    Constructor.isAnnotationPresent(Class)
    
    // 判断@Report是否存在于Person类:
    Person.class.isAnnotationPresent(Report.class);

使用反射API读取Annotation：

    Class.getAnnotation(Class)
    Field.getAnnotation(Class)
    Method.getAnnotation(Class)
    Constructor.getAnnotation(Class)

    / 获取Person定义的@Report注解:
    Report report = Person.class.getAnnotation(Report.class);
    int type = report.type();
    String level = report.level();
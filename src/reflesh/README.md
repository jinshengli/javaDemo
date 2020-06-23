#### 反射



##### 反射機制

可以通过类的class对象获取该类的所有信息，构造方法、成员变量、成员方法；



##### 获取Class对象的三种方式

    class 对象是有jvm加载class字节码到内存中生成的，一个class文件
    对应一个字节码文件。

###### 获取Class对象代码

  
    1. 任何一个数据类型的一个class静态属性
        Class clazz = Student.class;
    2. object 的一个getClass()方法
        Student student = new Student();
        Class aClass = student.getClass();
    3. Class类的静态方法 【常用】    
        Class aClass1 = Class.forName("reflesh.Student");


###### 通过反射获取构造方法

    1. 批量获取所有的构造器.
        Constructor[] constructors = clazz.getDeclaredConstructors();
    
    2. 获取所有【公有的】构造函数
        Constructor[] constructors = clazz.getConstructors();
        
    3. 获取一个构造函数；  范围：所有的方法中 paramClass = Class 类型数组
        Constructor declaredConstructor = clazz.getDeclaredConstructor(paramClass);
    
    4.  获取一个构造函数，从公共的构造方法中获取。
        Constructor constructor = clazz.getConstructor(paramClass);

调用构造方法对象 ----》 创建对象
    
    Object student = constructor.newInstance(id, name);


###### 通过反射获取类的属性。
    
    1. 获取当前类的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        
    2. 获取当前类的public属性
        Field[] fields = clazz.getFields();
        
    3. 获取当前类某个私有属性，并且给该属性赋值 【前提生成对象】
        Object object = constructor.newInstance();
        Field phoneNumField = clazz.getDeclaredField("phoneNum");
        phoneNumField.setAccessible(true); // 设置私有属性可访问
        phoneNumField.set(object,"17806262078");  // 给属性赋值
        
    4. 可以获取该类拥有的所有公共属性，包括继承父类公有的属性。        
        Object obj = constructor.newInstance();
        Field nameField = clazz.getField("name");
        nameField.set(obj, "ljs");
        
调用设置属性方法：

    phoneNumField.setAccessible(true); // 设置private可访问
    set(obj,value)    // obj 对象， value 值 
    
        
###### 通过反射获取类的方法；并且调用

    1.获取当前类定义所有的成员方法，包括私有的(不包括继承的)
    
    Method[] declaredMethods = clazz.getDeclaredMethods();
    
    2. 获取所有"公有方法"；（包含了父类的方法也包含Object类）
    
    Method[] methods = clazz.getMethods();
    
    
    3.获取一个公有方法；当前类 + 继承而来的共有方法。
    Method setOdMethod = clazz.getMethod("setName", String.class);
    Object obj = clazz.newInstance();
    setOdMethod.invoke(obj, "哈化娿");
    
    4. 获取当前类定义的一个方法。 包括公有 + 其他
    Method setNameMethod = clazz.getDeclaredMethod("test", Integer.class);
    setNameMethod.setAccessible(true);
    Object obj = clazz.newInstance();
    setNameMethod.invoke(obj, 100);
    

###### 通过配置文件，反射创建一个对象。

Properties 读取键值对的属性
    
    FileInputStream inputStream = new FileInputStream(new File("src/reflesh/st.txt"));
    properties.load(inputStream);
    String className = properties.getProperty("className");
    String method = properties.getProperty("method");
    
    Class clazz = Class.forName(className);
    Method declaredMethod = clazz.getDeclaredMethod(method);
    Object obj = clazz.newInstance();
    declaredMethod.setAccessible(true);
    declaredMethod.invoke(obj);

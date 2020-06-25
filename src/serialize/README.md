#### 对象序列化


##### 序列化

    通过序列化存储对象的状态
    
步骤：

    1)打开一个输出文件流；FileOutputStream
    2)一个对象流：os = ObjectOutputStream(fos)
    3)对象流输出： os.writeObject(obj)
    4)关闭流：os.close()

注意点：
        
    1. 如果要让对象能够被序列化，需要实现接口Serializable
    2. 为了让对象的某个成员变量不被保存（序列化），可添加关键字
        transient
    3. static的类变量不能被序列化，它属于类的部分，不属于对象
    4. 如果父类实现了Serializable接口，子类不需要声明了。


##### 反序列化

    还原对象    

步骤：

    1) 打开文件输入流 FileInputStream
    2) ObjectInputStream
    3) ois.readObject()
    4) ois.close()

注意点：
    
    1. 还原对象时，如果对于被transient修饰的变量，引用类型的为null，
        基本类型的为默认值，0,或者false
    2. 在解序列化时，所有的类都必须让java虚拟机找到。




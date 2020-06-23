#### io 流


##### 四种基本流【基类】


###### InputStream/OutputStream

字节输入流和字节输出流; 操作的单元是字节单元。

###### Reader/Writer

字符输入流和字节输出流；操作的单元是字符单元。



####处理文件的 IO 流

    1. FileInputStream
    2. FileOutputStream
    3. FileReader
    4. FileWriter


#### 高级流，带缓存流 
    
    1. BufferedInputStream(InputStream in)
    2. BufferedOutputStream(OutputStream out)
    3. BufferedReader(Reader reader)
    4. BufferedWriter(Writer writer)

对于处理文件的
缓存提高处理效率；减少从用户空间到操作系统空间之间的数据
交换次数。


#### InputStreamReader

字节 --->  字符

FileReader 就是继承这个类的。










package io;



import java.io.*;

/**
 * create by ljs on 2020/6/23 10:10
 * <p>
 * description:
 *          做一个带缓存处理流的 IO 实验
 *        BufferOutStream(OutputStream out);
 *
 *
 *
 */
public class BufferIo {

    /**
     *  带缓存的输出流。
     *     作用：
     *       该缓存流中，存在一个字节数组，每次用户输入字节数据后，先
     *       保存到该字节数组中，如果数组空间不足，或者数组已经满了，做一个
     *       flush操作，就是将该数组所有的数据保存到本地磁盘文件中。
     *     好处：
     *        先将数组保存到字节数组中，减少每次数据从用户态进入系统调用的次数。
     *        可以提高数据输入的次数。
     *
     * */
    public void BufferOut(File file) throws IOException {


        FileOutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream bfouts = new BufferedOutputStream(outputStream);

        for ( int i = 0; i < 10; ++i ) {

            String s = "这是啥" + i + '\n';
            byte[] bytes = s.getBytes();
            bfouts.write(bytes);

        }
        bfouts.close();
    }

    /**
     *  BufferedInputStream(InputStream in);
     *      带缓存，有个字节数组保存从输入流中读取的数据；
     *      下次读取字节的时候，直接从该缓存中读取，避免有从通过低级流读取数据；
     *      如果该缓存的数据被读取完毕，会调用fill；再次填充该数组。
     *
     *  如果输入流式FileInputStream; 那么会减少从磁盘读取数据的次数；
     *
     *  每次读取固定长度的数据保存到缓存区，然后每次读取从缓存读取、
     *
     */

    public void BufferIn(File file) throws IOException {


        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufin = new BufferedInputStream(fileInputStream);

        byte[] bytes = new byte[1000];

        int i;
        while ( ( i = bufin.read(bytes) ) != -1 ) {

            String string = new String(bytes,0,i ,"utf-8");
            System.out.println(string);
        }

        bufin.close();

    }

    /**
     *
     *  BufferWriter; 带缓存的字符处理流， 处理单元是字节
     *
     *  原来同上
     *
     *
     * */

    public void BufferWriter(File file) throws IOException {

        Writer writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);


        char[] chars = new char[200];

        for ( int i = 0; i < 10; ++i ) {
            java.lang.String string = "chars" + i +'\n';
            bufferedWriter.write(string);
        }
        bufferedWriter.close();
    }

    /*
        带缓存流的处理

          字符读取 + 缓存。
          有个特殊的读取方式； readLine() 读一行

     */
    public void bufferReader(File file) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String res;
        while ( ( res = reader.readLine() ) != null ) {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {

        File file = new File("src/io/buffer.txt");
        BufferIo bufferIo = new BufferIo();

//        bufferIo.BufferOut(file);
//        bufferIo.BufferIn(file);

        bufferIo.BufferWriter(file);
        bufferIo.bufferReader(file);

    }



}

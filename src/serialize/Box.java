package serialize;

import java.io.*;

/**
 * create by ljs on 2020/6/25 14:31
 * <p>
 * description: 序列化对象
 */
public class Box implements Serializable {

    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("src/serialize/box.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        Box box = new Box();
        os.writeObject(box);

    }

}

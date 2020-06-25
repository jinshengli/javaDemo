package serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * create by ljs on 2020/6/25 17:06
 * <p>
 * description:
 */
public class DeSerializaPond {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("src/serialize/pond.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Pond object = (Pond) objectInputStream.readObject();

        System.out.println(object);



    }


}

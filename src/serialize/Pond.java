package serialize;

import se.cast.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * create by ljs on 2020/6/25 14:37
 * <p>
 * description:
 */
public class Pond implements Serializable {

    private transient String currentID;
    private Duck duck;
    private transient Student student;

    public Pond() {
    }

    public Pond(String currentID, Duck duck, Student student) {
        this.currentID = currentID;
        this.duck = duck;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Pond{" +
                "currentID='" + currentID + '\'' +
                ", duck=" + duck +
                ", student=" + student +
                '}';
    }

    public static void main(String[] args) throws IOException {

        Pond pond = new Pond("中", new Duck("小雅"), new Student());
        System.out.println(pond);
        FileOutputStream fos = new FileOutputStream("src/serialize/pond.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(pond);


    }


}


class Duck implements Serializable {

    private String name;


    public Duck() {
    }

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                '}';
    }
}
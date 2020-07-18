package se.stringdemo;

import javax.lang.model.element.NestingKind;
import java.util.UUID;

public class UUIDDemo {



    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);

        String u = uuid.replace('-', ' ');
        System.out.println(u);

        String uu = uuid.replace("-", "");
        System.out.println(uu);

    }


}

package reflesh.annotation;

import java.lang.annotation.*;

/**
 * create by ljs on 2020/5/12 13:43
 *
 * 通过反射获取注解的值。
 *
 */

@Use
public class UseAnnotation {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class cls = UseAnnotation.class;

        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Use use = (Use) cls.getAnnotation(Use.class);

        System.out.println(use.id());
        System.out.println(use.name());



    }


}


@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Use{

    String name() default "la";

    String[] uselist() default {"woo", "bob"};

    int id() default 0;

}

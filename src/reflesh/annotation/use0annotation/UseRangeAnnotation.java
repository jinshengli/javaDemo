package reflesh.annotation.use0annotation;

import reflesh.annotation.Range;
import reflesh.annotation.Report;
import reflesh.annotation.bean.Person;

import java.lang.reflect.Field;

/**
 * create by ljs on 2020/7/1 19:41
 * <p>
 * description:  通过反射判断 Person 实例的字段是否符合要求。
 */
public class UseRangeAnnotation {

    public static void check(Person person) throws IllegalAccessException {

        Field[] fields = person.getClass().getFields();
        for (Field field : fields) {
            Range range = field.getAnnotation(Range.class);
            if ( range != null ) {
                Object value = field.get(person);
                if ( value instanceof String ) {
                    String s = (String) value;
                    if ( s.length() < range.min() || s.length() > range.max() ) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }

                if ( value instanceof Integer ) {
                    Integer age = (Integer) value;
                    if ( age < range.min() || age > range.max() ) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }

            }
        }
    }

    // 读取person类上的注解
    public static void readClassAnnotaion(Person person) {

        boolean b = person.getClass().isAnnotationPresent(Report.class);
        if ( b ) {
            Report report = person.getClass().getAnnotation(Report.class);
            System.out.println("value " + report.value());
            System.out.println("level " + report.level());
            System.out.println("type " + report.type());
        }


    }


    public static void main(String[] args) {

        Person person = new Person("weee", "2",32);

        readClassAnnotaion(person);


        try {
            check(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}

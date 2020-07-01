package reflesh.annotation.bean;

import reflesh.annotation.Range;
import reflesh.annotation.Report;

/**
 * create by ljs on 2020/7/1 19:37
 * <p>
 * description:  定义person, 设定属性的范围
 */
@Report(type = 1, level = "nb", value = "逆隋")
public class Person {

    @Range(min = 3, max = 30)
    public String name;

    @Range(max = 10)
    public String city;

    @Range(min = 18, max = 60)
    public Integer age;

    public Person(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

}

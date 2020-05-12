package reflesh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * create by ljs on 2020/5/12 12:19
 *
 * 注解在哪个位置  TYPE: 类或方法
 *
 * 注解在什么时候还生效 RUNTIME: 运行时
 *
 * 字段定义  类型 名称()
 */

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value();

}



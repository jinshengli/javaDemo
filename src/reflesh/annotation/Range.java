package reflesh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create by ljs on 2020/7/1 19:35
 * <p>
 * description:
 *      定义一个@Range注解， 用它来定义String字段的规则
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {

    int min() default 0;
    int max() default 255;

}

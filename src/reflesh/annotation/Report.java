package reflesh.annotation;

import java.lang.annotation.*;

/**
 * create by ljs on 2020/7/1 19:12
 * <p>
 * description:
 */
@Inherited
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {

    int type() default 0;
    String level() default "info";
    String value() default "";

}

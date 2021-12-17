package cn.wanggf.spring.javafx.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 视图注解
 *
 * @author wanggf
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface View {
    /**
     * 视图名称
     *
     * @return 视图名称
     * @see Component#value()
     */
    @AliasFor(value = "value", annotation = Component.class)
    String value() default "";

    /**
     * 指定fxml文件名
     *
     * @return fxml文件
     */
    String name() default "";
}

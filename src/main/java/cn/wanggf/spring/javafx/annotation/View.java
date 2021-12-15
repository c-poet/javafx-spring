package cn.wanggf.spring.javafx.annotation;

/**
 * 视图注解
 *
 * @author wanggf
 */
public @interface View {
    /**
     * 指定fxml文件名
     *
     * @return fxml文件
     */
    String value() default "";
}

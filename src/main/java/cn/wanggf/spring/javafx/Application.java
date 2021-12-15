package cn.wanggf.spring.javafx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * application父类
 *
 * @author wanggf
 */
public abstract class Application extends javafx.application.Application {
    protected final ApplicationContext applicationContext;

    public Application() {
        this.applicationContext = new AnnotationConfigApplicationContext(getClass());
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}

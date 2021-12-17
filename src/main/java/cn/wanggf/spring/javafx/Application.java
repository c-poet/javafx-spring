package cn.wanggf.spring.javafx;

import cn.wanggf.spring.javafx.support.FxBeanPostProcessor;
import cn.wanggf.spring.javafx.support.FxViewHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * application父类
 *
 * @author wanggf
 */
public abstract class Application extends javafx.application.Application {
    private FxViewHandler fxViewHandler;

    protected final GenericApplicationContext applicationContext;

    public Application() {
        this(new AnnotationConfigApplicationContext());
    }

    public Application(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        loadContext();
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 初始化上下文
     */
    protected void loadContext() {
        applicationContext.registerBean(FxBeanPostProcessor.class);
        if (applicationContext instanceof AnnotationConfigRegistry) {
            ((AnnotationConfigRegistry) applicationContext)
                .scan(getPackageName());
        }
        applicationContext.refresh();
    }

    /**
     * 获取当前类所在包名
     *
     * @return 当前类所在包名
     */
    private String getPackageName() {
        return ClassUtils.getPackageName(getClass());
    }
}

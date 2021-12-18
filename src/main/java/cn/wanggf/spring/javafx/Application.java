package cn.wanggf.spring.javafx;

import cn.wanggf.spring.javafx.support.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

/**
 * application父类
 *
 * @author wanggf
 */
public abstract class Application extends javafx.application.Application {
    protected GenericApplicationContext applicationContext;
    protected FxConfiguration fxConfiguration;

    public Application() {
        initializeContext();
    }

    public void initializeContext() {
        FxConfiguration fxConfiguration = FxConfigurationBuilder
            .builder()
            .addBasePackages(getPackageName())
            .build();
        initializeContext(fxConfiguration);
    }

    public void initializeContext(FxConfiguration fxConfiguration) {
        initializeContext(new AnnotationConfigApplicationContext(), fxConfiguration);
    }

    public void initializeContext(GenericApplicationContext applicationContext, FxConfiguration fxConfiguration) {
        Assert.notNull(applicationContext, "application context cannot be null.");
        Assert.notNull(fxConfiguration, "need to pass in javafx configuration.");
        this.applicationContext = applicationContext;
        this.fxConfiguration = fxConfiguration;
        if (fxConfiguration.isInitialScanPackage()) {
            // 视图处理器
            FxViewHandler fxViewHandler = new DefaultFxViewHandler(fxConfiguration, applicationContext);
            // 注册bean处理器
            applicationContext.registerBean(FxViewBeanPostProcessor.class, fxViewHandler);
            String[] basePackages = fxConfiguration.getBasePackages();
            if (basePackages != null && basePackages.length > 0 && applicationContext instanceof AnnotationConfigRegistry) {
                ((AnnotationConfigRegistry) applicationContext).scan(basePackages);
            }
            applicationContext.refresh();
        }
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

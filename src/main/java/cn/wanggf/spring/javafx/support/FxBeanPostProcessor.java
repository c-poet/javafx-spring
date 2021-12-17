package cn.wanggf.spring.javafx.support;

import cn.wanggf.spring.javafx.annotation.View;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 对目标bean进行处理
 *
 * @author wanggf
 */
public class FxBeanPostProcessor implements BeanPostProcessor {
    private final FxViewHandler fxViewHandler;

    public FxBeanPostProcessor(final @Autowired(required = false) FxViewHandler fxViewHandler,
                               final @Autowired(required = false) FxConfiguration fxConfiguration,
                               final ApplicationContext applicationContext) {
        this.fxViewHandler = fxViewHandler == null
            ? new DefaultFxViewHandler(withDefaultConfig(fxConfiguration), applicationContext) : fxViewHandler;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        View view = AnnotationUtils.findAnnotation(bean.getClass(), View.class);
        if (view == null) {
            return bean;
        }
        return fxViewHandler.handle(view, bean, beanName);
    }

    private FxConfiguration withDefaultConfig(FxConfiguration fxConfiguration) {
        if (fxConfiguration != null) {
            return fxConfiguration;
        }
        return FxConfigurationBuilder.builder().build();
    }
}

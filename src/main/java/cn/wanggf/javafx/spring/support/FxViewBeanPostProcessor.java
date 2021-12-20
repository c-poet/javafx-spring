package cn.wanggf.javafx.spring.support;

import cn.wanggf.javafx.spring.annotation.View;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 对目标bean进行处理
 *
 * @author wanggf
 */
public class FxViewBeanPostProcessor implements BeanPostProcessor {
    private final FxViewHandler fxViewHandler;

    public FxViewBeanPostProcessor(final FxViewHandler fxViewHandler) {
        this.fxViewHandler = fxViewHandler;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        View view = AnnotationUtils.findAnnotation(bean.getClass(), View.class);
        if (view == null) {
            return bean;
        }
        return fxViewHandler.handle(view, bean, beanName);
    }
}

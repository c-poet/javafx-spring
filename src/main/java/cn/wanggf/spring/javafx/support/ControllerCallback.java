package cn.wanggf.spring.javafx.support;

import javafx.util.Callback;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 * 控制器工厂回调
 *
 * @author wanggf
 */
public class ControllerCallback<R> implements Callback<Class<? extends R>, R> {
    private final ApplicationContext applicationContext;

    public ControllerCallback(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public R call(Class<? extends R> clazz) {
        Assert.notNull(clazz, "No controller type specified.");
        return applicationContext.getBean(clazz);
    }
}

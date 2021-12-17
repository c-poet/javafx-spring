package cn.wanggf.spring.javafx;

import cn.wanggf.spring.javafx.annotation.View;
import cn.wanggf.spring.javafx.core.FxView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.util.Map;

/**
 * application父类
 *
 * @author wanggf
 */
public abstract class Application extends javafx.application.Application {
    protected final GenericApplicationContext applicationContext;

    public Application() {
        applicationContext = new AnnotationConfigApplicationContext(getPackageName());
        loadFx();
    }

    public Application(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        loadFx();
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 加载fx信息
     */
    private void loadFx() {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(View.class);
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object bean = entry.getValue();
            View view = AnnotationUtils.findAnnotation(bean.getClass(), View.class);
            Assert.notNull(view, "There is no view annotation in the view.");
            loadFxView(bean, view);
        }
    }

    private void loadFxView(Object bean, View view) {
        String viewName = getViewName(bean, view);
        System.out.println(viewName);
        if (bean instanceof FxView) {
//            CustomFxmlLoader.load();
        }
    }

    /**
     * 获取视图名称
     *
     * @param bean bean
     * @param view 视图注解
     * @return 视图名称
     */
    private String getViewName(Object bean, View view) {
        if (!view.name().isEmpty()) {
            return view.name();
        }
        String name = ClassUtils.getShortName(bean.getClass());
        if (name.length() > 4 && name.endsWith("View")) {
            name = name.substring(0, name.length() - 4);
        }
        return name.substring(0, 1).toLowerCase() + name.substring(1);
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

package cn.wanggf.spring.javafx.core;

import cn.wanggf.spring.javafx.exception.NotFoundViewException;
import cn.wanggf.spring.javafx.support.ControllerCallback;
import cn.wanggf.spring.javafx.support.CustomFxmlLoader;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * {@link FxView}实现
 *
 * @author wanggf
 */
public class FxViewImpl implements FxView, MethodInterceptor {
    private final FxViewMeta fxViewMeta;
    private final ResourceLoader resourceLoader;
    private final ControllerCallback<Object> controllerCallback;

    public FxViewImpl(FxViewMeta fxViewMeta,
                      ResourceLoader resourceLoader,
                      ControllerCallback<Object> controllerCallback) {
        this.fxViewMeta = fxViewMeta;
        this.resourceLoader = resourceLoader;
        this.controllerCallback = controllerCallback;
    }

    @Override
    public <T> T view() throws NotFoundViewException {
        try {
            return CustomFxmlLoader.load(getViewPath(), controllerCallback);
        } catch (IOException e) {
            throw new NotFoundViewException("failed to load view.", e);
        }
    }

    @Override
    public URL getViewPath() {
        return getClassLoader().getResource(fxViewMeta.getPath());
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Class<?> declaringClass = method.getDeclaringClass();
        if (declaringClass == FxView.class) {
            return methodProxy.invoke(this, objects);
        }
        Object originView = fxViewMeta.getOriginView();
        return methodProxy.invoke(originView, objects);
    }

    private ClassLoader getClassLoader() {
        ClassLoader classLoader = resourceLoader.getClassLoader();
        return classLoader == null ? CustomFxmlLoader.getDefaultClassLoader() : classLoader;
    }
}

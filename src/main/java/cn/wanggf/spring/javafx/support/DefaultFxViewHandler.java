package cn.wanggf.spring.javafx.support;

import cn.wanggf.spring.javafx.annotation.View;
import cn.wanggf.spring.javafx.core.FxView;
import cn.wanggf.spring.javafx.core.FxViewImpl;
import cn.wanggf.spring.javafx.core.FxViewMeta;
import cn.wanggf.spring.javafx.core.FxViewMetaBuilder;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 默认实现的视图处理器
 *
 * @author wanggf
 */
public class DefaultFxViewHandler implements FxViewHandler {
    private final static char NAME_UNDERSCORE_CHAR = '_';

    private final FxConfiguration fxConfiguration;
    private final ApplicationContext applicationContext;

    public DefaultFxViewHandler(FxConfiguration fxConfiguration, final ApplicationContext applicationContext) {
        this.fxConfiguration = fxConfiguration;
        this.applicationContext = applicationContext;
    }

    @Override
    public Object handle(View view, Object bean, String beanName) {
        FxViewMetaBuilder builder = FxViewMetaBuilder.builder();
        loadFxViewMeta(builder, beanName, view, bean);
        return createProxy(builder.build(), bean.getClass());
    }

    private Object createProxy(FxViewMeta fxViewMeta, Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{FxView.class});
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new FxViewImpl(fxViewMeta, applicationContext, applicationContext::getBean));
        return enhancer.create();
    }

    private void loadFxViewMeta(FxViewMetaBuilder builder, String viewName, View view, Object originView) {
        builder
            .withName(viewName)
            .withPath(getViewPath(viewName, view.name()))
            .withOriginView(originView);
    }

    private String getViewPath(String viewName, String anoName) {
        String tarName = anoName;
        if (tarName.isEmpty()) {
            tarName = fxConfiguration.isAutoViewPath() ? handleViewNameRule(viewName) : viewName;
        }
        String viewPrefix = fxConfiguration.getViewPrefix();
        if (StringUtils.hasText(viewPrefix)) {
            tarName = viewPrefix + tarName;
        }
        String viewSuffix = fxConfiguration.getViewSuffix();
        if (StringUtils.hasText(viewSuffix)) {
            tarName += viewSuffix;
        }
        return tarName;
    }

    private String handleViewNameRule(String viewName) {
        switch (fxConfiguration.getViewNameRule()) {
            case CAMEL:
                return StringUtils.uncapitalize(viewName);
            case PASCAL:
                return StringUtils.capitalize(viewName);
            case UNDERSCORE:
                char[] chars = viewName.toCharArray();
                StringBuilder builder = new StringBuilder(chars.length);
                for (int i = 0; i < chars.length; i++) {
                    if (Character.isUpperCase(chars[i])) {
                        if (i != 0) {
                            builder.append(NAME_UNDERSCORE_CHAR);
                        }
                        builder.append(Character.toLowerCase(chars[i]));
                    } else {
                        builder.append(chars[i]);
                    }
                }
                return builder.toString();
            default:
        }
        return viewName;
    }
}

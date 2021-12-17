package cn.wanggf.spring.javafx.support;

import cn.wanggf.spring.javafx.annotation.View;

/**
 * 视图处理器
 *
 * @author wanggf
 */
public interface FxViewHandler {
    /**
     * 处理视图
     *
     * @param view     视图注解信息
     * @param bean     视图实例对象
     * @param beanName 视图实例bean名称
     * @return 增强过后的视图对象
     */
    Object handle(View view, Object bean, String beanName);
}

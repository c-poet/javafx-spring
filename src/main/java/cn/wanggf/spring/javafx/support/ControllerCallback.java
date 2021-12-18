package cn.wanggf.spring.javafx.support;

import javafx.util.Callback;

/**
 * 控制器工厂回调
 *
 * @author wanggf
 */
public interface ControllerCallback<R> extends Callback<Class<? extends R>, R> {
}

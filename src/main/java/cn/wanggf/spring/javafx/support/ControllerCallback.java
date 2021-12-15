package cn.wanggf.spring.javafx.support;

import javafx.util.Callback;

/**
 * 控制器工厂回调
 *
 * @author wanggf
 */
public class ControllerCallback<R> implements Callback<Class<? extends R>, R> {

    @Override
    public R call(Class<? extends R> param) {
        return null;
    }
}

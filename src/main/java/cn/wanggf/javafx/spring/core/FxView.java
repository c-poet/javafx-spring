package cn.wanggf.javafx.spring.core;

import cn.wanggf.javafx.spring.exception.NotFoundViewException;
import javafx.scene.Parent;

import java.net.URL;

/**
 * 视图接口
 *
 * @author wanggf
 */
public interface FxView {
    /**
     * 获取视图
     *
     * @return 视图
     * @throws NotFoundViewException 视图获取异常
     */
    default <T> T view() throws NotFoundViewException {
        throw new NotFoundViewException("get view failed.");
    }

    /**
     * 获取视图地址
     *
     * @return 视图地址
     * @throws NotFoundViewException 视图获取异常
     */
    default URL getViewPath() throws NotFoundViewException {
        throw new NotFoundViewException("get view path failed.");
    }

    /**
     * 获取视图元信息
     *
     * @return 视图元信息
     * @throws NotFoundViewException 视图元信息不存在
     */
    default FxViewMeta getFxViewMeta() throws NotFoundViewException {
        throw new NotFoundViewException("View meta information does not exist.");
    }
}

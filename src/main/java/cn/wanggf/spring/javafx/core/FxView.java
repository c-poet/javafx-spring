package cn.wanggf.spring.javafx.core;

import cn.wanggf.spring.javafx.exception.NotFoundViewException;
import javafx.scene.Parent;

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
    default Parent view() throws NotFoundViewException {
        throw new NotFoundViewException("get view failed.");
    }
}

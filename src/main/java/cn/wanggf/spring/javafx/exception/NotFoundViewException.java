package cn.wanggf.spring.javafx.exception;

/**
 * 视图查找异常
 *
 * @author wanggf
 */
public class NotFoundViewException extends FxException {
    public NotFoundViewException(String message) {
        super(message);
    }

    public NotFoundViewException(String message, Throwable cause) {
        super(message, cause);
    }
}

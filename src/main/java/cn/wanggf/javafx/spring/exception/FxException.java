package cn.wanggf.javafx.spring.exception;

/**
 * 运行时异常基类
 *
 * @author wanggf
 */
public class FxException extends RuntimeException {
    public FxException(String message) {
        super(message);
    }

    public FxException(String message, Throwable cause) {
        super(message, cause);
    }
}

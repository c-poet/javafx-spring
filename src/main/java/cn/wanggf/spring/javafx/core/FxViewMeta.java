package cn.wanggf.spring.javafx.core;

/**
 * 视图元信息
 *
 * @author wanggf
 */
public class FxViewMeta {
    /**
     * 视图名称
     */
    private String name;

    /**
     * 视图路径
     */
    private String path;

    /**
     * 内联FxView
     */
    private FxView fxView;

    FxViewMeta() {
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    void setFxView(FxView fxView) {
        this.fxView = fxView;
    }

    public FxView getFxView() {
        return fxView;
    }
}

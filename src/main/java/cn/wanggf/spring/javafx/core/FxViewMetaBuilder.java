package cn.wanggf.spring.javafx.core;

/**
 * 视图元信息builder
 *
 * @author wanggf
 */
public class FxViewMetaBuilder {
    private final FxViewMeta fxViewMeta;

    private FxViewMetaBuilder(FxViewMeta fxViewMeta) {
        this.fxViewMeta = fxViewMeta;
    }

    public FxViewMetaBuilder withName(String name) {
        fxViewMeta.setName(name);
        return this;
    }

    public FxViewMetaBuilder withPath(String path) {
        fxViewMeta.setPath(path);
        return this;
    }

    public FxViewMetaBuilder withFxView(FxView fxView) {
        fxViewMeta.setFxView(fxView);
        return this;
    }

    public static FxViewMetaBuilder builder() {
        return new FxViewMetaBuilder(new FxViewMeta());
    }

    public static FxViewMetaBuilder builder(FxViewMeta fxViewMeta) {
        FxViewMetaBuilder builder = FxViewMetaBuilder.builder();
        return builder
            .withName(fxViewMeta.getName())
            .withPath(fxViewMeta.getPath())
            .withFxView(fxViewMeta.getFxView());
    }
}

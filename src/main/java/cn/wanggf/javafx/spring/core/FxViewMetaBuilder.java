package cn.wanggf.javafx.spring.core;

/**
 * 视图元信息builder
 *
 * @author wanggf
 */
public final class FxViewMetaBuilder {
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

    public FxViewMetaBuilder withOriginView(Object originView) {
        fxViewMeta.setOriginView(originView);
        return this;
    }

    public FxViewMeta build() {
        return fxViewMeta;
    }

    public static FxViewMetaBuilder builder() {
        return new FxViewMetaBuilder(new FxViewMeta());
    }

    public static FxViewMetaBuilder builder(FxViewMeta fxViewMeta) {
        FxViewMetaBuilder builder = FxViewMetaBuilder.builder();
        return builder
            .withName(fxViewMeta.getName())
            .withPath(fxViewMeta.getPath())
            .withOriginView(fxViewMeta.getOriginView());
    }
}

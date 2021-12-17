package cn.wanggf.spring.javafx.support;

/**
 * @author wanggf
 */
public final class FxConfigurationBuilder {
    /**
     * 是否自动处理视图路径
     * <p>只有该值设成{@code true}时，{@link #viewNameRule}才有效</p>
     */
    private boolean autoViewPath = true;

    /**
     * 是否命名时使用的规则
     */
    private FxViewNameRuleEnum viewNameRule = FxViewNameRuleEnum.PASCAL;

    /**
     * 视图读取前缀
     */
    private String viewPrefix = "view/";

    /**
     * 视图读取后缀
     */
    private String viewSuffix = ".fxml";

    private FxConfigurationBuilder() {
    }

    public static FxConfigurationBuilder builder() {
        return new FxConfigurationBuilder();
    }

    public FxConfigurationBuilder withAutoViewPath(boolean autoViewPath) {
        this.autoViewPath = autoViewPath;
        return this;
    }

    public FxConfigurationBuilder withViewNameRule(FxViewNameRuleEnum viewNameRule) {
        this.viewNameRule = viewNameRule;
        return this;
    }

    public FxConfigurationBuilder withViewPrefix(String viewPrefix) {
        this.viewPrefix = viewPrefix;
        return this;
    }

    public FxConfigurationBuilder withViewSuffix(String viewSuffix) {
        this.viewSuffix = viewSuffix;
        return this;
    }

    public FxConfiguration build() {
        FxConfiguration fxConfiguration = new FxConfiguration();
        fxConfiguration.setAutoViewPath(autoViewPath);
        fxConfiguration.setViewNameRule(viewNameRule);
        fxConfiguration.setViewPrefix(viewPrefix);
        fxConfiguration.setViewSuffix(viewSuffix);
        return fxConfiguration;
    }
}

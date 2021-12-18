package cn.wanggf.spring.javafx.support;

/**
 * 配置
 *
 * @author wanggf
 */
public class FxConfiguration {
    /**
     * 是否自动处理视图路径
     * <p>只有该值设成{@code true}时，{@link #viewNameRule}才有效</p>
     */
    private boolean autoViewPath;

    /**
     * 自动命名时使用的规则
     */
    private FxViewNameRuleEnum viewNameRule;

    /**
     * 视图读取前缀
     */
    private String viewPrefix;

    /**
     * 视图读取后缀
     */
    private String viewSuffix;

    /**
     * 是否初始化扫描包
     */
    private boolean initialScanPackage;

    /**
     * spring扫描的包
     */
    private String[] basePackages;

    FxConfiguration() {
    }

    public boolean isAutoViewPath() {
        return autoViewPath;
    }

    void setAutoViewPath(boolean autoViewPath) {
        this.autoViewPath = autoViewPath;
    }

    public FxViewNameRuleEnum getViewNameRule() {
        return viewNameRule;
    }

    void setViewNameRule(FxViewNameRuleEnum viewNameRule) {
        this.viewNameRule = viewNameRule;
    }

    public String getViewPrefix() {
        return viewPrefix;
    }

    void setViewPrefix(String viewPrefix) {
        this.viewPrefix = viewPrefix;
    }

    public String getViewSuffix() {
        return viewSuffix;
    }

    void setViewSuffix(String viewSuffix) {
        this.viewSuffix = viewSuffix;
    }

    public boolean isInitialScanPackage() {
        return initialScanPackage;
    }

    void setInitialScanPackage(boolean initialScanPackage) {
        this.initialScanPackage = initialScanPackage;
    }

    public String[] getBasePackages() {
        return basePackages;
    }

    void setBasePackages(String[] basePackages) {
        this.basePackages = basePackages;
    }
}

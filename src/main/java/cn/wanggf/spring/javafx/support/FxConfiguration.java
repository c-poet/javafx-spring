package cn.wanggf.spring.javafx.support;

/**
 * 配置
 *
 * @author wanggf
 */
public class FxConfiguration {
    private boolean autoViewPath;

    private FxViewNameRuleEnum viewNameRule;

    private String viewPrefix;

    private String viewSuffix;

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
}

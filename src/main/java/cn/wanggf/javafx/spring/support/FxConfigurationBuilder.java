package cn.wanggf.javafx.spring.support;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wanggf
 */
public final class FxConfigurationBuilder {
    /**
     * @see FxConfiguration#setAutoViewPath(boolean)
     */
    private boolean autoViewPath = true;

    /**
     * @see FxConfiguration#setViewNameRule(FxViewNameRuleEnum)
     */
    private FxViewNameRuleEnum viewNameRule = FxViewNameRuleEnum.PASCAL;

    /**
     * @see FxConfiguration#setViewPrefix(String)
     */
    private String viewPrefix = "view/";

    /**
     * @see FxConfiguration#setViewSuffix(String)
     */
    private String viewSuffix = ".fxml";

    /**
     * @see FxConfiguration#setInitialScanPackage(boolean)
     */
    private boolean initialScanPackage = true;

    /**
     * @see FxConfiguration#setBasePackages(String[])
     */
    private final Set<String> basePackages = new HashSet<>();

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

    public FxConfigurationBuilder withInitialScanPackage(boolean initialScanPackage) {
        this.initialScanPackage = initialScanPackage;
        return this;
    }

    public FxConfigurationBuilder addBasePackages(String... basePackages) {
        return addBasePackages(Arrays.asList(basePackages));
    }

    public FxConfigurationBuilder addBasePackages(Collection<String> basePackages) {
        this.basePackages.addAll(basePackages);
        return this;
    }

    public FxConfiguration build() {
        FxConfiguration fxConfiguration = new FxConfiguration();
        fxConfiguration.setAutoViewPath(autoViewPath);
        fxConfiguration.setViewNameRule(viewNameRule);
        fxConfiguration.setViewPrefix(viewPrefix);
        fxConfiguration.setViewSuffix(viewSuffix);
        fxConfiguration.setInitialScanPackage(initialScanPackage);
        fxConfiguration.setBasePackages(basePackages.toArray(new String[0]));
        return fxConfiguration;
    }
}

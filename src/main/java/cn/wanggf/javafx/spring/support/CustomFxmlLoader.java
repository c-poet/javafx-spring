package cn.wanggf.javafx.spring.support;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;

/**
 * 扩展fxml加载器
 *
 * @author wanggf
 */
public class CustomFxmlLoader extends FXMLLoader {
    /**
     * 加载视图
     *
     * @param location          视图地址
     * @param controllerFactory 控制器工厂
     * @return 视图
     * @throws IOException 视图加载失败
     */
    public static <T> T load(URL location, Callback<Class<?>, Object> controllerFactory) throws IOException {
        return load(location, null, null, controllerFactory);
    }
}

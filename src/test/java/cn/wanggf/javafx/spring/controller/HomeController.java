package cn.wanggf.javafx.spring.controller;

import cn.wanggf.javafx.spring.core.FxController;
import cn.wanggf.javafx.spring.view.HomeView;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author wanggf
 */
@Controller
public class HomeController implements FxController, InitializingBean {
    @Autowired
    private HomeView homeView;

    @Override
    public void afterPropertiesSet() {
        assert homeView != null;
        assert homeView.view() != null;
    }
}

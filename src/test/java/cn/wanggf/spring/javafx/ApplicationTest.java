package cn.wanggf.spring.javafx;


import cn.wanggf.spring.javafx.controller.HomeController;
import cn.wanggf.spring.javafx.view.HomeView;
import javafx.stage.Stage;

public class ApplicationTest extends Application {
    @Override
    public void start(Stage primaryStage) {
        HomeController bean = applicationContext.getBean(HomeController.class);
        System.out.println(bean);
        HomeView bean1 = applicationContext.getBean(HomeView.class);
        System.out.println(bean1);
    }
}
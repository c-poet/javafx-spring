package cn.wanggf.spring.javafx;


import cn.wanggf.spring.javafx.controller.HomeController;
import cn.wanggf.spring.javafx.view.HomeView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class ApplicationTest extends Application {
    @Override
    public void start(Stage primaryStage) {
        HomeView homeView = applicationContext.getBean(HomeView.class);
        primaryStage.setScene(new Scene(homeView.view()));
        primaryStage.show();
    }
}
package com.example.sc;

import com.example.service.LoginBackEnd;
import com.example.service.ManageBackEnd;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;

public class HomePage {
    private static final double STAGE_MIN_WIDTH = 650;  // 舞台最小宽度
    private static final double STAGE_MIN_HEIGHT = 450; // 舞台最小高度
    public static Stage first(){
        Stage stage=new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(50);

        //垂直面板 第一行
        Label label1=new Label("单项选择题考试系统");
        //垂直框架 第二行 水平面板
        HBox hBox=new HBox();
        hBox.setSpacing(25);//容器内组件间距
        //第二行 水平面板内容
        Label label2=new Label("学号/密钥");
        label1.setFont(new Font("Arial",30));
        label2.setFont(new Font("Arial",20));
        TextField textField1=new TextField();
        hBox.getChildren().addAll(label2,textField1);
        //第三行 登录按钮
        HBox hBox1=new HBox();
        Button button1=new Button("登录");
        Button button2=new Button("添加试题");
        button1.setStyle("-fx-background-color: #07bafb;-fx-font-size:16;-fx-text-fill: white ");
        button2.setStyle("-fx-background-color: #07bafb;-fx-font-size:16;-fx-text-fill: white ");
        hBox1.getChildren().addAll(button1,button2);
        hBox1.setSpacing(125);



        //登录场景，学生端
        button1.setOnAction(actionEvent -> {
            stage.close();
            //获得学号
            String name=textField1.getText();
            //将获得的学号传递到LoginBackEnd
            try {
                if (LoginBackEnd.login(name)) {
                    //展示成功界面
                    ChooseFirst.cf().show();
                } else if (!LoginBackEnd.login(name)) {
                    //展示登录失败界面
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("提示");
                                alert.setHeaderText("账号不存在");
                                alert.showAndWait();
                    HomePage.first().show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        //登录场景，题目添加端
        button2.setOnAction(actionEvent -> {
            stage.close();
            //获得密钥
            String name=textField1.getText();
            //将获得的学号传递到ManageBackEnd
            try {
                if (ManageBackEnd.login(name)) {
                    //展示成功界面
                    AdministratorPage.cf().show();
                } else if (!ManageBackEnd.login(name)) {
                    //展示登录失败界面
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("提示");
                    alert.setHeaderText("账号不存在");
                    alert.showAndWait();
                    HomePage.first().show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });


        //全部放入VBOX
        vBox.getChildren().addAll(label1,hBox,hBox1);

        //定位
        vBox.setLayoutX(200);
        vBox.setLayoutY(140);

        //背景图片属性设置
        ImageView view=new ImageView();
        //加载图片
        Image image=new Image("C:\\Users\\26077\\IdeaProjects\\SC\\src\\main\\resources\\Image\\5.jpg");
        view.setImage(image);
        // 计算适应舞台的宽度和高度
        double fitWidth = Math.min(image.getWidth(),STAGE_MIN_WIDTH);
        double fitHeight = Math.min(image.getHeight(), STAGE_MIN_HEIGHT);
        // 设置ImageView的适应舞台的宽度和高度
        view.setFitWidth(fitWidth);
        view.setFitHeight(fitHeight);

        AnchorPane pane=new AnchorPane();
        pane.getChildren().addAll(view,vBox);

        //舞台配置
            //标题
        stage.setTitle("单项选择题考试系统");
        Scene scene=new Scene(pane,STAGE_MIN_WIDTH,STAGE_MIN_HEIGHT);
        stage.setResizable(false);//用户不可改变窗口大小
        stage.setScene(scene);


        return stage;
    }
}

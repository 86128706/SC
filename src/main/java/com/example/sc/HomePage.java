package com.example.sc;

import com.example.service.LoginBackEnd;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
    public static Stage first(){
        Stage stage=new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(20);

        //垂直面板 第一行
        Label label1=new Label("单项选择题考试系统");
        //垂直框架 第二行 水平面板
        HBox hBox=new HBox();
        hBox.setSpacing(20);//容器内组件间距
        //第二行 水平面板内容
        Label label2=new Label("学号/密钥");
        label1.setFont(new Font("Arial",28));
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


        //登录场景
        button1.setOnAction(actionEvent -> {
            stage.close();
            //获得学号
            String name=textField1.getText();


            //判断学号能否登录(未完成)
            //将获得的学号传递到LoginBackEnd
//            try {
//                if (LoginBackEnd.login(name)) {
//                    //展示成功界面
//                    ChooseFirst.cf().show();
//                } else if (!LoginBackEnd.login(name)) {
//                    //展示登录失败界面
//                    ChooseFirst.df().show();
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            ChooseFirst.cf().show();
        });

        button2.setOnAction(actionEvent -> {
            stage.close();
            AdministratorPage.cf().show();
        });

        //背景
        ImageView view=new ImageView();
        Image image=new Image("C:\\Users\\26077\\IdeaProjects\\SC\\src\\main\\resources\\Image\\1.jpg");
        view.setImage(image);
        //全部放入VBOX
        vBox.getChildren().addAll(label1,hBox,hBox1);

        //定位
        vBox.setLayoutX(210);
        vBox.setLayoutY(150);

        vBox.setSpacing(30);
        hBox.setSpacing(20);
        hBox1.setSpacing(20);
        AnchorPane pane=new AnchorPane();
        pane.getChildren().addAll(view,vBox);
        Scene scene=new Scene(pane,650,450);
        stage.setResizable(false);//用户不可改变窗口大小
        stage.setScene(scene);
        stage.setMinWidth(650);
        stage.setMinHeight(450);
        return stage;
    }
}

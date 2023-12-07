package com.example.sc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.LoginBackEnd;

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
        Label label2=new Label("学号");
        TextField textField1=new TextField();
        hBox.getChildren().addAll(label2,textField1);
        //第三行 登录按钮
        Button button1=new Button("登录");
        button1.setStyle("-fx-background-color: #07bafb;-fx-font-size:16;-fx-text-fill: white ");


        //登录场景
        button1.setOnAction(actionEvent -> {
            //获得学号
            String name=textField1.getText();


            //判断学号能否登录(未完成)
            //将获得的学号传递到LoginBackEnd
            if (LoginBackEnd.login(name)==1) {
                //展示成功界面
                ChooseFirst.cf().show();
            } else if (LoginBackEnd.login(name)==0) {
                //展示登录失败界面
                ChooseFirst.df().show();
            }



        });

        //全部放入VBOX
        vBox.getChildren().addAll(label1,hBox,button1);
        vBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox);
        stage.setResizable(false);//用户不可改变窗口大小
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(250);
       return  stage;
    }
}

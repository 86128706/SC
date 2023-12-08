package com.example.sc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

//登录成功界面
public class ChooseFirst {

    public static  Stage cf(){
        Stage stage=new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(20);


        //垂直框架 第二行 水平面板
        HBox hBox=new HBox();
        hBox.setSpacing(20);//容器内组件间距
        //第二行 水平面板内容
        Label label2=new Label("题量选择");
        TextField textField1=new TextField();
        hBox.getChildren().addAll(label2,textField1);
        //第三行 登录按钮
        Button button1=new Button("确定");


        //鼠标事件，跳转至题目界面
        button1.setOnAction(actionEvent -> {
            stage.close();
            //获取题量数据
            String text = textField1.getText();
            int number = Integer.parseInt(text);
            //展示题目界面 传递题量数据
            try {
                ChoosePage.examination(number).show();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
        //放入VBOX
        vBox.getChildren().addAll(hBox,button1);
        hBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(250);
        stage.setResizable(false);//用户不可改变窗口大小
        return stage;

    }

    //登录失败界面
    public static  Stage df() {
        Stage stage = new Stage();
        VBox vBox = new VBox();
        Label label2 = new Label("登录失败");
        Button button1 = new Button("确定");
        stage.setMinWidth(650);
        stage.setMinHeight(450);
        stage.setResizable(false);//用户不可改变窗口大小
        //缺少确定的点击结果
        return stage;
    }
}

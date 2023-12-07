package com.example.sc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoosePage {
    public static Stage examination(int number){
        Stage stage=new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(20);

        //第一行题目
        Label label1=new Label("(变量，题目序号)+（数据库题目）");
        //第二行四个选项
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton t1=new RadioButton("A:"+"数据库选项");//如何读取数据库内容
        RadioButton t2=new RadioButton("B:"+"数据库选项");
        RadioButton t3=new RadioButton("C:"+"数据库选项");
        RadioButton t4=new RadioButton("D:"+"数据库选项");
        t1.setToggleGroup(toggleGroup);
        t2.setToggleGroup(toggleGroup);
        t3.setToggleGroup(toggleGroup);
        t4.setToggleGroup(toggleGroup);
        //第三行 登录按钮
        Button button1=new Button("确定");

        //判断是否正确，更新界面刷新题目，刷新次数由题量决定
        //ChoseFirst传递过来刷新题目的数量 接受传递数据number
        //设置单题分数individual
        double individual= (double) 100 /number;
        //根据题目量设置每题分数
        button1.setOnAction(actionEvent -> {
          //  未写
        });


        //放入VBOX
        vBox.getChildren().addAll(label1,t1,t2,t3,t4,button1);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(250);
        stage.setResizable(false);//用户不可改变窗口大小
        return stage;
    }
}

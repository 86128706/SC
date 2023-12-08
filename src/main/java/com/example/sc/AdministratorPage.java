package com.example.sc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdministratorPage {
    public static Stage cf(){
        Stage stage=new Stage();
        VBox hBox=new VBox();
        HBox vBox1=new HBox();
        HBox vBox2=new HBox();
        HBox vBox3=new HBox();
        HBox vBox4=new HBox();
        HBox vBox5=new HBox();
        HBox vBox6=new HBox();
        HBox hBox7=new HBox();

        TextField timu=new TextField();
        TextField A=new TextField();
        TextField B=new TextField();
        TextField C=new TextField();
        TextField D=new TextField();

        Label label1=new Label("试题添加");

        timu.setPromptText("请输入题目");
        A.setPromptText("请输入A选项");
        B.setPromptText("请输入B选项");
        C.setPromptText("请输入C选项");
        D.setPromptText("请输入D选项");

        Button BC=new Button("保存");
        Button XYG=new Button("下一个");
        Button QQ=new Button("退出");

        vBox1.getChildren().add(timu);
        vBox2.getChildren().add(A);
        vBox3.getChildren().add(B);
        vBox4.getChildren().add(C);
        vBox5.getChildren().add(D);
        vBox6.getChildren().addAll(BC,XYG,QQ);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton t1=new RadioButton("A");//如何读取数据库内容
        RadioButton t2=new RadioButton("B");
        RadioButton t3=new RadioButton("c");
        RadioButton t4=new RadioButton("D");
        t1.setToggleGroup(toggleGroup);
        t2.setToggleGroup(toggleGroup);
        t3.setToggleGroup(toggleGroup);
        t4.setToggleGroup(toggleGroup);
        hBox7.getChildren().addAll(t1,t2,t3,t4);

        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        vBox3.setAlignment(Pos.CENTER);
        vBox4.setAlignment(Pos.CENTER);
        vBox5.setAlignment(Pos.CENTER);
        vBox6.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        hBox7.setAlignment(Pos.CENTER);

        BC.setOnAction(actionEvent -> {
            //  未写 保存数据 弹出保存完成
        });
        XYG.setOnAction(actionEvent -> {
            //  未写 填写下一个题目 刷新界面
        });
        QQ.setOnAction(actionEvent -> {
            //  未写 返回 返回至上一页
        });

        hBox.getChildren().addAll(label1,vBox1,vBox2,vBox3,vBox4,vBox5,hBox7,vBox6);
        Scene scene=new Scene(hBox);
        stage.setScene(scene);
        stage.setMinWidth(650);
        stage.setMinHeight(450);
        stage.setResizable(false);//用户不可改变窗口大小
        return stage;

    }
}

package com.example.sc;

import com.example.util.TopicTransfer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ChoosePage {
    public static Stage examination(int number) throws SQLException {
        int i=0;
        Stage stage=new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(20);

        TopicTransfer topicTransfer = new TopicTransfer();

        //第一行题目
        Label label1=new Label(topicTransfer.getSitumon());
        label1.setMaxWidth(630); // 设置最大宽度
        label1.setWrapText(true);//限制换行
        //第二行四个选项
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton t1=new RadioButton("A:"+topicTransfer.getOptionsA());//如何读取数据库内容
        RadioButton t2=new RadioButton("B:"+topicTransfer.getOptionsB());
        RadioButton t3=new RadioButton("C:"+topicTransfer.getOptionsC());
        RadioButton t4=new RadioButton("D:"+topicTransfer.getOptionsD());
        t1.setToggleGroup(toggleGroup);
        t2.setToggleGroup(toggleGroup);
        t3.setToggleGroup(toggleGroup);
        t4.setToggleGroup(toggleGroup);
        //第三行 登录按钮
        Button button1=new Button("下一题");

        //判断是否正确，更新界面刷新题目，刷新次数由题量决定
        //ChoseFirst传递过来刷新题目的数量 接受传递数据number
        //设置单题分数individual
        double individual= (double) 100 /number;
        //根据题目量设置每题分数
        button1.setOnAction(actionEvent -> {

          vBox.getChildren().clear();
          vBox.getChildren().addAll(label1,t1,t2,t3,button1);
        });


        //放入VBOX
        vBox.getChildren().addAll(label1,t1,t2,t3,t4,button1);
        vBox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.setMinWidth(650);
        stage.setMinHeight(450);
        stage.setResizable(false);//用户不可改变窗口大小
        return stage;
    }
}

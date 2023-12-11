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

public class Lastpage {
    private static final double STAGE_MIN_WIDTH = 650;  // 舞台最小宽度
    private static final double STAGE_MIN_HEIGHT = 450; // 舞台最小高度
    public static Stage first(int sum){
        Stage stage=new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(50);

        //垂直面板 第一行
        Label label1=new Label("考试完成");
        label1.setFont(new Font("Arial",30));
        //垂直框架 第二行 水平面板
        HBox hBox=new HBox();
        hBox.setSpacing(25);//容器内组件间距
        //第二行 水平面板内容
        Label label2=new Label("您的成绩是");
        label2.setFont(new Font("Arial",20));
        //显示分数

        Label fraction=new Label(String.valueOf(sum));
        hBox.getChildren().addAll(label2,fraction);
        //第三行 登录按钮
        Button button1=new Button("退出");
        button1.setStyle("-fx-background-color: #07bafb;-fx-font-size:16;-fx-text-fill: white ");


        //退出该界面
        button1.setOnAction(actionEvent -> {
            stage.close();
            HomePage.first().show();
        });
        //全部放入VBOX
        vBox.getChildren().addAll(label1,hBox,button1);




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
        stage.setTitle("总成绩");
        Scene scene=new Scene(pane,STAGE_MIN_WIDTH,STAGE_MIN_HEIGHT);
        stage.setResizable(false);//用户不可改变窗口大小
        stage.setScene(scene);


        return stage;
    }
}

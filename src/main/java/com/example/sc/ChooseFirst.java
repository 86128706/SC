package com.example.sc;

import javafx.geometry.Pos;
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
import javafx.stage.Stage;

import java.sql.SQLException;

//登录成功界面
public class ChooseFirst {
    private static final double STAGE_MIN_WIDTH = 650;  // 舞台最小宽度
    private static final double STAGE_MIN_HEIGHT = 450; // 舞台最小高度
    public static Stage cf() {
        Stage stage = new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        ImageView view = new ImageView();
        Image image = new Image("C:\\Users\\26077\\IdeaProjects\\SC\\src\\main\\resources\\Image\\1.jpg");
        view.setImage(image);

        //垂直框架 第二行 水平面板
        HBox hBox = new HBox();
        hBox.setSpacing(20);//容器内组件间距
        //第二行 水平面板内容
        Label label2 = new Label("题量设置");
        TextField textField1 = new TextField();
        hBox.getChildren().addAll(label2, textField1);
        //第三行 登录按钮
        Button button1 = new Button("确定");
        button1.setStyle("-fx-background-color: #07bafb;-fx-font-size:16;-fx-text-fill: white ");


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

        vBox.setLayoutX(210);
        vBox.setLayoutY(150);

        //放入VBOX
        vBox.getChildren().addAll(hBox, button1);
        hBox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        AnchorPane pane = new AnchorPane();
        pane.getChildren().addAll(view, vBox);

        //背景图片设置
        // 计算适应舞台的宽度和高度
        double fitWidth = Math.min(image.getWidth(),STAGE_MIN_WIDTH);
        double fitHeight = Math.min(image.getHeight(), STAGE_MIN_HEIGHT);
        // 设置ImageView的适应舞台的宽度和高度
        view.setFitWidth(fitWidth);
        view.setFitHeight(fitHeight);

        //舞台设置
        stage.setTitle("选题设置");
        Scene scene = new Scene(pane, STAGE_MIN_WIDTH, STAGE_MIN_HEIGHT);
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(250);
        stage.setResizable(false);//用户不可改变窗口大小
        return stage;

    }
}


//    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("提示");
//                                alert.setHeaderText("账号不存在");
//                                alert.showAndWait();

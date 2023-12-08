package com.example.sc;

import com.example.util.TopicTransfer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;


public class ChoosePage {
    static int flag=1;
    static double sum=0;
    public static Stage examination(int number) throws SQLException {
        int i=0;
        Stage stage=new Stage();
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        ImageView view=new ImageView();
        Image image=new Image("D:\\JavaSE\\SC\\src\\main\\resources\\Image\\1.jpg");
        view.setImage(image);
        HashSet<Integer> hashSet = new HashSet<>();
        do {
            int ran = (int) (Math.random() * 10);
            if (ran != 0) {
                hashSet.add(ran);
            }
        } while (hashSet.size() != number);

        Iterator<Integer> iterator = hashSet.iterator();

        TopicTransfer topicTransfer = new TopicTransfer(iterator.next(),number);

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
        //根据题目量设置每题分数
        button1.setOnAction(actionEvent -> {
            if (flag<number){
                flag++;
                if (t1.isSelected()){
                    sum+=topicTransfer.r("A");
                }else if (t2.isSelected()){
                    sum+=topicTransfer.r("B");
                }else if (t3.isSelected()){
                    sum+=topicTransfer.r("B");
                }else if (t4.isSelected()){
                    sum+=topicTransfer.r("D");
                }
                try {
                    topicTransfer.find(iterator.next());
                    label1.setText(topicTransfer.getSitumon());
                    t1.setText("A:"+topicTransfer.getOptionsA());
                    t2.setText("B:"+topicTransfer.getOptionsB());
                    t3.setText("C:"+topicTransfer.getOptionsC());
                    t4.setText("D:"+topicTransfer.getOptionsD());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else if (flag==number){
                if (t1.isSelected()){
                    sum+=topicTransfer.r("A");
                }else if (t2.isSelected()){
                    sum+=topicTransfer.r("B");
                }else if (t3.isSelected()){
                    sum+=topicTransfer.r("B");
                }else if (t4.isSelected()){
                    sum+=topicTransfer.r("D");
                }
                flag=999999;
            }
            System.out.println(sum);
        });


        //放入VBOX
        vBox.getChildren().addAll(label1,t1,t2,t3,t4,button1);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(210);
        vBox.setLayoutY(100);
        vBox.setSpacing(20);
        AnchorPane pane=new AnchorPane();
        pane.getChildren().addAll(view,vBox);
        Scene scene=new Scene(pane,650,450);
        stage.setScene(scene);
        stage.setMinWidth(650);
        stage.setMinHeight(450);
        stage.setResizable(false);//用户不可改变窗口大小
        return stage;
    }
}

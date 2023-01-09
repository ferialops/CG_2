package com.example.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.Group;


public class HelloApplication extends Application {
    MyEllipse myEllipse = new MyEllipse(0, 0, 0, 0);


    public void start(Stage stage) {
        stage.setTitle("drawing ellipse");

        Label lblX = new Label("Write X");
        TextField textFieldX = new TextField("10");
        Label lblY = new Label("Write Y");
        TextField textFieldY = new TextField("10");
        Label lblW = new Label("Write Width");
        TextField textFieldW = new TextField("80");
        Label lblH = new Label("Write Height");
        TextField textFieldH = new TextField("90");

        Button drawEllipse = new Button("draw ellipse");
        final Canvas canvas = new Canvas(250,250);


        final Group group = new Group();
        drawEllipse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                myEllipse.setX(Integer.parseInt(textFieldX.getText()));
                myEllipse.setY(Integer.parseInt(textFieldY.getText()));
                myEllipse.setWidth(Integer.parseInt(textFieldW.getText()));
                myEllipse.setHeight(Integer.parseInt(textFieldH.getText()));
                GraphicsContext gc = canvas.getGraphicsContext2D();
                myEllipse.draw(gc);
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, lblX, textFieldX, lblY, textFieldY, lblW,
                textFieldW,  lblH, textFieldH, drawEllipse, group, canvas);


        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 400);

        stage.setScene(scene);

        stage.show();
    }

}
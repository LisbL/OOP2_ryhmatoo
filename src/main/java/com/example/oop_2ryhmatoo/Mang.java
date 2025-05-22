package com.example.oop_2ryhmatoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Mang extends Application {

    @Override
    public void start(Stage lava) throws IOException {
        try {
            Parent juur = FXMLLoader.load(getClass().getResource("/com/example/oop_2ryhmatoo/Pealehekylg.fxml"));
            lava.setTitle("RIP Monke");

            Scene stseen = new Scene(juur);
            lava.setScene(stseen);
            lava.show();
        }  catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}
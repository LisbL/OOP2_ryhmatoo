package com.example.oop_2ryhmatoo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Mang extends Application {
    private static final int PIKKUS = 600;
    private static final int LAIUS = 800;

    @Override
    public void start(Stage lava) throws IOException {
        lava.setTitle("RIP Monke");

        StackPane paneel = new StackPane();
        Canvas canvas = new Canvas(LAIUS, PIKKUS);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        paneel.getChildren().add(canvas);

        Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000.0/60), e -> update(gc)));
        loop.setCycleCount(Animation.INDEFINITE);
        loop.play();

        Scene stseen = new Scene(paneel,LAIUS, PIKKUS);
        lava.setScene(stseen);
        lava.show();

        Button stardinupp = new Button("START");
        stardinupp.setLayoutX(100);
        stardinupp.setLayoutY(100);
        paneel.getChildren().add(stardinupp);
    }

    private void update(GraphicsContext gc) {
        gc.clearRect(0,0, LAIUS, PIKKUS);
        gc.setFill(Color.NAVAJOWHITE);
        gc.fillRect(0, 0, LAIUS, PIKKUS);
    }

    public static void main(String[] args) {
        launch();
    }
}
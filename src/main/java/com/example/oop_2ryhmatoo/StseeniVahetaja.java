package com.example.oop_2ryhmatoo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StseeniVahetaja {
    private static Stage pealava;

    public static void seaPealava(Stage lava) {
        pealava = lava;
    }

    public static void vaheta(String fxml) {
        try {
            Parent juur = FXMLLoader.load(StseeniVahetaja.class.getResource(fxml));
            pealava.setScene(new Scene(juur));
            pealava.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void vahetaTulemusega(String fxml, String tulemus) {
        try {
            FXMLLoader laadija = new FXMLLoader(StseeniVahetaja.class.getResource(fxml));
            Parent juur = laadija.load();

            tulemusKontrollimine kontroller = laadija.getController();
            kontroller.kuvaTulemus(tulemus);

            pealava.setScene(new Scene(juur));
            pealava.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

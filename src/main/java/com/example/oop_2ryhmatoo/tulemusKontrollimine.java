package com.example.oop_2ryhmatoo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class tulemusKontrollimine {
    @FXML
    private Label tulemus;
    @FXML
    private Button uuestiNupp, sulgeNupp;

    public void initialize() {
        uuestiNupp.setOnAction(event -> {
            StseeniVahetaja.vaheta("Valik.fxml");
        });

        sulgeNupp.setOnAction(event -> {
            Stage lava = (Stage) sulgeNupp.getScene().getWindow();
            lava.close();
        });
    }

    public void kuvaTulemus(String sonum) {
        tulemus.setText(sonum);
    }
}

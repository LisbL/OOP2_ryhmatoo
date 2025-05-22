package com.example.oop_2ryhmatoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class stseeniKontrollimine {
    private Scene stseen;

    @FXML
    public void vahetaKarakterValikusse(ActionEvent event) throws IOException {
        FXMLLoader laadija = new FXMLLoader(getClass().getResource("/com/example/oop_2ryhmatoo/Valik.fxml"));
        Parent juur = laadija.load();

        Stage lava = (Stage)((Node)event.getSource()).getScene().getWindow();
        stseen = new Scene(juur);
        lava.setScene(stseen);
        lava.show();
    }
}

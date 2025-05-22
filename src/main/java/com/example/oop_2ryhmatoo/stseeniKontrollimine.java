package com.example.oop_2ryhmatoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class stseeniKontrollimine {
    private Stage lava;
    private Scene stseen;
    private Parent juur;

    public void vahetaPealeheküljele(ActionEvent event){

    }

    public void vahetaKarakterValikusse(ActionEvent event) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("Valik.fxml"));
        lava = (Stage)((Node)event.getSource()).getScene().getWindow();
        stseen = new Scene(juur);
        lava.setScene(stseen);
        lava.show();
    }

    public void vahetaVoitlusesse(ActionEvent event) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("Voitlus.fxml"));
        lava = (Stage)((Node)event.getSource()).getScene().getWindow();
        stseen = new Scene(juur);
        lava.setScene(stseen);
        lava.show();
    }
}

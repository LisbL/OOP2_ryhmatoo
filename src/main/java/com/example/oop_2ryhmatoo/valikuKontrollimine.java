package com.example.oop_2ryhmatoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class valikuKontrollimine {
    @FXML
    private ChoiceBox<Draakon> draakonValik;
    @FXML
    private Label veateade;

    private Täring täring = new Täring(1, 6);
    private ErilineKäik tulepall = new ErilineKäik("Tulepall", 15, täring);
    private ErilineKäik purskkaev = new ErilineKäik("Purskkaev", 20, täring);
    private ErilineKäik maavärin = new ErilineKäik("Maavärin", 14, täring);

    public valikuKontrollimine() throws IOException {
    }

    @FXML
    public void initialize() {
        draakonValik.getItems().addAll(
                new Draakon("Tuledraakon", 10, 100, tulepall, täring),
                new Draakon("Veedraakon", 15, 85, purskkaev, täring),
                new Draakon("Maadraakon", 7, 120, maavärin, täring)
        );
        //Vaikimisi esimene valik
        draakonValik.getSelectionModel().selectFirst();
    }

    @FXML
    private void vahetaVoitlusesse(ActionEvent event) throws IOException {
        Draakon valitud = draakonValik.getSelectionModel().getSelectedItem();

        if (valitud == null) {
            veateade.setText("Palun vali draakon!");
            return;
        }
        veateade.setText(""); //Kustutab veateate, kui õnnestus

        //Võitluse jaoks uus stseen
        FXMLLoader laadija = new FXMLLoader(getClass().getResource("Voitlus.fxml"));
        Parent juur = laadija.load();
        //Võitluse kontroller
        voitluseKontrollimine kontroller = laadija.getController();
        //Saadab valitud draakoni edasi
        kontroller.seadistaMangija(valitud);

        //Uus stseen
        Stage lava = (Stage) ((Node) event.getSource()).getScene().getWindow();
        lava.setScene(new Scene(juur));
        lava.show();
    }
}

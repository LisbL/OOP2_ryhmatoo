package com.example.oop_2ryhmatoo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class voitluseKontrollimine {
    @FXML private Button ryndaNupp;
    @FXML private Button erilineNupp;
    @FXML private Button magaNupp;
    @FXML private TextArea logiVali;

    private Draakon mangija;
    private Draakon vastane;

    public void seadistaMangija(Draakon mangija) {
        this.mangija = mangija;
        Täring täring = new Täring(1, 6);
        this.vastane = new Draakon("MONKE 2000", 5, 100, new ErilineKäik("Banaani vise", 12, täring), täring);
        logi("Võitlus algas! Valitud draakon: " + mangija.getNimi());
    }

    @FXML
    public void rynda() {
        logi("Rünnakukäik - - -");
        mangija.ründa(vastane);
        kontrolliSeisund();
        arvutiKäik();
    }

    @FXML
    private void kasutaErilineKäik() {
        logi("Eriline käik!!!");
        mangija.kasutaErilistKäiku(vastane);
        kontrolliSeisund();
        arvutiKäik();
    }

    @FXML
    private void maga() {
        logi("Draakon norskab. . .");
        arvutiKäik();
    }

    private void arvutiKäik() {
        if (vastane.läksMagama() || mangija.läksMagama()) return;

        logi("Arvuti kord - - -");
        int vastus = (Math.random() < 0.5) ? 1 : 2;
        if (vastus == 1) {
            vastane.ründa(mangija);
        } else {
            vastane.kasutaErilistKäiku(mangija);
        }

        kontrolliSeisund();
    }

    private void kontrolliSeisund() {
        if (vastane.läksMagama()) {
            logi(mangija.getNimi() + " võitis!!");
            nupudKeelatud();
        } else if (mangija.läksMagama()) {
            logi("Sa kaotasid...");
            nupudKeelatud();
        }
    }

    private void nupudKeelatud() {
        ryndaNupp.setDisable(true);
        erilineNupp.setDisable(true);
        magaNupp.setDisable(true);
    }

    private void logi(String tekst) {
        logiVali.appendText(tekst + "\n");
    }
}

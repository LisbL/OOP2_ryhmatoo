/*
 -  Suhtlemine kasutajaga peab olema realiseeritud JavaFX graafilise kasutajaliidese abil.
    Erandid lubatud juhtudel, kui JavaFX kasutamine ei ole võimalik.
    Programm peab töötlema nii hiire kui ka klaviatuuriga tekitatud sündmusi.
 -  Programmi akna suurust muutes peab kuvatu mõistlikult muutuma.
 -  Erinditöötluse abil tagada, et toimuks mõistlik reageerimine
    (vähemalt mõnedele) kasutaja ekslikele tegevustele (nt. sisestustele).
 -  Programm peab mingid andmed kirjutama faili ja
    neid failist ka lugema. Näiteks võib tekitada logifaili ja selle põhjal
    korraldada käikude tagasivõtmise.
 */

import java.util.Scanner;

public class Põhimäng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vali draakon :)");
        System.out.println("Tuledraakon - 1");
        System.out.println("Veedraakon - 2");
        System.out.println("Maadraakon - 3");

        Täring täring = new Täring(1, 6);

        ErilineKäik tulepall = new ErilineKäik("Tulepall", 15,täring);
        ErilineKäik purskkaev = new ErilineKäik("Purskkaev", 20, täring);
        ErilineKäik maavärin = new ErilineKäik("Maavärin", 14, täring);


        Draakon[] draakonid = { // draakonid, kelle seast valida
                new Draakon("Tuledraakon", 10, 100, tulepall, täring),
                new Draakon("Veedraakon", 15, 85, purskkaev, täring),
                new Draakon("Maadraakon", 7, 120, maavärin, täring)
        };
        int valik = sc.nextInt() - 1;
        Draakon mängija = draakonid[valik];
        Draakon vastane = new Draakon("MONKE 2000",5, 105, new ErilineKäik("Banaani vise", 12, täring), täring);

        // Põhimäng
        while (!mängija.läksMagama() && !vastane.läksMagama()) {
            // Mängija kord
            MängijaKord(mängija);
            valik = sc.nextInt();
            if (valik == 1) {
                mängija.ründa(vastane);
            } else if (valik == 2) {
                mängija.kasutaErilistKäiku(vastane);
            } else {
                System.out.println("Sellist valikut pole olemas! Käik jääb vahele.");
            }
            // Kontroll, kas mängija võitis
            if (vastane.läksMagama()) {
                System.out.println(vastane + " kukkus kokku! Sa võitsid!!!");
                break;
            }

            //Arvuti kord
            System.out.println(vastane + "kord...");
            int valik2 = (Math.random() < 0.5) ? 1 : 2;

            if (valik2 == 1) {
                vastane.ründa(mängija);
            } else {
                vastane.kasutaErilistKäiku(mängija);
            }
            // Kontroll, kas mängija suri
            if (mängija.läksMagama()) {
                System.out.println(mängija + " kukkus kokku! Sa kaotasid! :(");
                break;
            }
            System.out.println("--- Uus käik ---");
        }
        sc.close();
    }

    public static void MängijaKord(Draakon p) { // Lisameetod, et tsüklis vähem ridu oleks
        System.out.println("Vali tegevus: ");
        System.out.println("Ründa - 1");
        System.out.println("Supervõime (" + p.getErilineKäik() + ") - 2");
    }
}

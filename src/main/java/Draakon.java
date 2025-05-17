public class Draakon {
    private String nimi;
    private int dmg;
    private int HP;
    private int energia;
    private ErilineKäik erilineKäik;
    private Täring täring;

    public Draakon(String nimi, int dmg, int HP, ErilineKäik erilineKäik, Täring täring) {
        this.nimi = nimi;
        this.HP = HP;
        this.dmg = dmg;
        this.erilineKäik = erilineKäik;
        this.täring = täring;
        this.energia = 60;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getDmg() {
        return dmg;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public ErilineKäik getErilineKäik() { return erilineKäik; }

    public void ründa(Draakon vastane) { //Tavaline löök
        täring.viska();
        double kordaja = getKordaja(täring.getVisatud());
        int lõppDMG = (int) (kordaja * getDmg());
        vastane.setHP(vastane.getHP() - lõppDMG);

        System.out.println(nimi + " ründab vastast " + vastane.getNimi());
        System.out.println("Täring andis: " + täring.getVisatud());
        System.out.println(vastane + " kaotas " + lõppDMG + " HP-d");
        if (vastane.läksMagama()) {
            vastane.setHP(0);
        } else {
            System.out.println(vastane + " jäi järgi " + vastane.getHP() + " HP-d");
        }
        try {
            Thread.sleep(2000); // paus enne järgmist tegevust
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void kasutaErilistKäiku(Draakon vastane) { // Eriline löök
        if (energia > 0) { //Kui on piisavalt energiat, siis töötab
            erilineKäik.kasuta(this, vastane);
            energia -= 20;
        } else {
            System.out.println("Pole piisavalt energiat.");
        }

    }

    private double getKordaja(int roll) { // Kordaja saamine täringu viskest
        return switch (roll) {
            case 1 -> 0.5;
            case 2, 3 -> 1.0;
            case 4, 5 -> 1.5;
            case 6 -> 2.0;
            default -> 1.0;
        };
    }

    public boolean läksMagama() { //Juhul kui elud said otsa
        if (this.getHP() <= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return nimi;
    }
}

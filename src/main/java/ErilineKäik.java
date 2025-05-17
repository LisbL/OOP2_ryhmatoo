public class ErilineKäik {
    private String nimetus;
    private int baasDMG;
    private Täring täring;

    public ErilineKäik(String nimetus, int baasDMG, Täring täring) {
        this.nimetus = nimetus;
        this.baasDMG = baasDMG;
        this.täring = täring;
    }

    public void kasuta(Draakon p1, Draakon p2) {
        täring.viska(); //juhusliku numbri saamine, sellest löögikordaja tegemine
        double kordaja = getKordaja(täring.getVisatud());
        int lõppDMG = (int) (kordaja * baasDMG);
        p2.setHP(p2.getHP() - lõppDMG);

        System.out.println(p1 + " kasutab supervõimet " + nimetus + " " + p2 + " vastu!");
        System.out.println("Täringuvise andis: " + täring.getVisatud());
        System.out.println(p2 + " kaotas " + lõppDMG + " HP-d.");
        if (p2.läksMagama()) {
            p2.setHP(0);
        } else {
            System.out.println(p2 + " jäi järgi " + p2.getHP() + " HP-d");
        }
        try {
            Thread.sleep(2000); // paus enne järgmist tegevust
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getKordaja(int roll) { //Täringust saadud numbri konverteerimine
        return switch (roll) {
            case 1 -> 0.5; // nõrk
            case 2, 3 -> 1.0; // tavaline
            case 4, 5 -> 1.5; // tugev
            case 6 -> 2.0; // kriitiline
            default -> 1.0;
        };
    }

    @Override
    public String toString() {
        return nimetus;
    }
}

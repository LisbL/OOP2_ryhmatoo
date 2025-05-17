import java.util.Random;

public class Täring {
    private int alampiir;
    private int ülempiir;
    private int visatud;

    public Täring(int alampiir, int ülempiir) {
        this.alampiir = alampiir;
        this.ülempiir = ülempiir;
    }

    public int getAlampiir() {
        return alampiir;
    }

    public void setAlampiir(int alampiir) {
        this.alampiir = alampiir;
    }

    public int getÜlempiir() {
        return ülempiir;
    }

    public void setÜlempiir(int ülempiir) {
        this.ülempiir = ülempiir;
    }

    public int getVisatud() {
        return visatud;
    }

    public void viska() {
        Random rand = new Random();
        visatud = alampiir + rand.nextInt(ülempiir - alampiir + 1);
        System.out.println("Visati täringut");
    }
}

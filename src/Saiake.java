import java.util.Random;

public class Saiake {
    private String nimi;
    private double hind;

    public Saiake(String nimi, double hind) {
        this.nimi = nimi;
        this.hind = hind;
    }

    public String getNimi() {
        return nimi;
    }

    public double getHind() {
        return hind;
    }

    @Override
    public String toString() {
        return nimi + hind + " eurot";
    }

}

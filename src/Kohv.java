public class Kohv {
    private double hind;
    private String nimi;
    private final String[] koostisosad;

    Kohv(String nimi, double hind, String[] koostisosad) {
        this.nimi = nimi;
        this.hind = hind;
        this.koostisosad = koostisosad;
    }

    public double getHind() {
        return hind;
    }

    public void setHind(double hind) {
        this.hind = hind;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String[] getKoostisosad() {
        return koostisosad;
    }

    public String toString() {
        return nimi + " " + hind + " eurot";
    }
}

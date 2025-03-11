public class Kohv {
    private double hind;
    private String nimi;
    private String[] koostisosad;

    Kohv(double hind, String nimi, String[] koostisosad) {
        this.hind = hind;
        this.nimi = nimi;
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

    public String toString() {
        return nimi + ", " + hind + " eurot.";
    }
}

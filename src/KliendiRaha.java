import java.util.ArrayList;
import java.util.Random;

public class KliendiRaha {
    private double raha;

    public double rahakott(ArrayList<Kohv> kohvimenuu, ArrayList<Saiake> saiamenuu){
        double maxKohv = 0;
        for (Kohv kohv : kohvimenuu) { //Leiab menüüst kõige kallima kohvi
            if (kohv.getHind() > maxKohv) {
                maxKohv = kohv.getHind();
            }
        }
        double maxSai = 0;
        for (Saiake sai : saiamenuu) { //Leiab menüüst kõige kallima saia
            if (sai.getHind() > maxSai) {
                    maxSai = sai.getHind();
            }
        }
        double maxsumma = maxKohv + maxSai + 5; //Lisasin 5, et õnnelike klientide hulk oleks natuke suurem

        Random r = new Random();
        raha = r.nextDouble() * maxsumma; //Kliendil on raha vahemikus 0 kuni maxsumma

        return raha;
    }
}

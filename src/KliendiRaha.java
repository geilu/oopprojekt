import java.util.ArrayList;
import java.util.Random;

public class KliendiRaha {
    private double raha;

    public double rahakott(ArrayList<Kohv> kohvimenuu, ArrayList<Saiake> saiamenuu){
        double maxKohv = 0;
        double minKohv = Double.MAX_VALUE;
        for (Kohv kohv : kohvimenuu) {
            if (kohv.getHind() > maxKohv) {
                maxKohv = kohv.getHind();
            }
            if (kohv.getHind() < minKohv) {
                minKohv = kohv.getHind();
            }
        }
        double maxSai = 0;
        double minSai = Double.MAX_VALUE;
        for (Saiake sai : saiamenuu) {
            if (sai.getHind() > maxSai) {
                    maxSai = sai.getHind();
            }
            if (sai.getHind() < minSai) {
                minSai = sai.getHind();
            }
        }
        double maxsumma = maxKohv + maxSai + 3;
        double minsumma = minKohv + minSai;

        if (minsumma > 1){
            minsumma -= 1;
        }

        Random r = new Random();
        raha = r.nextDouble() * maxsumma;

        return raha;
    }
}

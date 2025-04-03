import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // kohvid
        Kohv espresso = new Kohv("Espresso", 2.5, new String[]{"espresso"});
        Kohv americano = new Kohv("Americano", 3.25, new String[]{"espresso", "kuum vesi"});
        Kohv latte = new Kohv("Latte", 3.5, new String[]{"espresso", "piim"});
        Kohv mocha = new Kohv("Mocha", 3.75, new String[]{"espresso", "piim", "šokolaad"});
        Saiake kohvisai = new Saiake("Kohvisai", 1.5);
        Saiake moskvasai = new Saiake("Moskvasai", 1.8);

        //Loob listid ja lisab tooted nendesse
        ArrayList<Kohv> kohvimenuu = new ArrayList<>();
        ArrayList<Saiake> saiamenuu = new ArrayList<>();
        kohvimenuu.add(espresso);
        kohvimenuu.add(americano);
        kohvimenuu.add(latte);
        kohvimenuu.add(mocha);
        saiamenuu.add(kohvisai);
        saiamenuu.add(moskvasai);


        Scanner sc = new Scanner(System.in);
        // main program loop
        while (true) {
            System.out.println("Valikud:\n1. Lõpeta programm\n2. Vaata menüüd\n3. Alusta tööpäevaga");
            String sisend = sc.nextLine();
            int onnelikudKliendid = 0;
            int kurvadkliendid = 0;

            Random r = new Random();
            int mituKlienti = r.nextInt(8) + 1; // genereerib suvalise arvu kliente vahemikus 1 kuni 8
            switch (sisend) {
                case "1":
                    System.out.println("Programmi töö lõpetatakse");
                    return;
                case "2":
                    System.out.println("---Menüü---\n");
                    System.out.println("Saiad--->");
                    for (Saiake saiake : saiamenuu) {
                        System.out.println(saiake);
                    }
                    System.out.println("Joogid--->");
                    for (Kohv kohv : kohvimenuu) {
                        System.out.println(kohv);
                    }
                    break;
                case "3":
                    System.out.println("Tööpäev algas, teenindada " + mituKlienti + " klienti");
                    for (int i = 0; i < mituKlienti; i++) {
                        boolean kliendiRahulolu = toopaev(kohvimenuu, saiamenuu);
                        if (kliendiRahulolu) {
                            onnelikudKliendid++;
                        } else {
                            kurvadkliendid++;
                        }
                    }
                    System.out.println("Tööpäev lõppes\nÕnnelikke kliente: " + onnelikudKliendid + "\nKurbi kliente: " + kurvadkliendid);
                    break;
                default:
                    System.out.println("Vale sisestus, proovi uuesti"); break;
            }
            System.out.println();
        }
    }

    private static boolean toopaev(ArrayList<Kohv> kohvimenuu, ArrayList<Saiake> saiamenuu) { // returnib false kui klient lahkub kurvana ja true kui klient lahkub onnelikuna
        KliendiRaha klient = new KliendiRaha();
        double kliendiRaha = klient.rahakott(kohvimenuu, saiamenuu);
        Random r = new Random();

        //Valib suvalise joogi ja saia
        int kohv = r.nextInt(kohvimenuu.size());
        int sai = r.nextInt(saiamenuu.size());
        //Leiab selle kohvi ja saia ning jätab selle nime ja hinna meelde
        String randomKohv = kohvimenuu.get(kohv).getNimi();
        double kohviHind = kohvimenuu.get(kohv).getHind();
        String randomSai = saiamenuu.get(sai).getNimi();
        double saiaHind = saiamenuu.get(sai).getHind();

        double tellimuseHind = kohviHind + saiaHind;

        System.out.println("Klient soovib: 1 " + randomSai + " ja 1 " + randomKohv);
        System.out.println("See on kokku " + tellimuseHind + " eurot");

        if (kliendiRaha >= tellimuseHind){
            System.out.println("Kliendil on piisavalt raha\n(Klient on õnnelik)\n");
        }else{
            System.out.println("Kliendil ei olnud piisavalt palju raha ja lahkus\n(Klient on kurb)\n");
            return false;
        }

        System.out.println("Valige koostisosad (\"lõpeta\" lõpetab valimise):");
        System.out.println("1. espresso\n2. kuum vesi\n3. piim\n4. šokolaad");

        List<String> valitudKoostisosad = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String sisend;
        while (true) {
            sisend = sc.nextLine();
            if (sisend.equals("lõpeta")) {
                break;
            }
            switch (sisend) { // loopib ja lisab valitud koostisosad kuni lõpetamiseni
                case "1":
                    System.out.println("Lisasite espresso");
                    valitudKoostisosad.add("espresso");
                    break;
                case "2":
                    System.out.println("Lisasite kuuma vett");
                    valitudKoostisosad.add("kuum vesi");
                    break;
                case "3":
                    System.out.println("Lisasite piima");
                    valitudKoostisosad.add("piim");
                    break;
                case "4":
                    System.out.println("Lisasite šokolaadi");
                    valitudKoostisosad.add("šokolaad");
                     break;
                default:
                    System.out.println("Vale sisestus, proovi uuesti");
            }
        }

        Kohv tehtudKohv = kasTegiKohvi(kohvimenuu, valitudKoostisosad);
        if (valitudKoostisosad.isEmpty() || tehtudKohv == null) { // kui ei valitud uhtegi koostisosadest voi valiti valed
            System.out.println("Ei teinud sobivat kohvi");
        } else {
            System.out.println("Kohv " + tehtudKohv.getNimi() + " on valmis");
            if (tehtudKohv.getNimi().equals(randomKohv)) {
                System.out.println("Kohv on sama, mis tellitud\n(Klient on õnnelik)\n");
                return true;
            } else {
                System.out.println("Kohv ei ole sama, mis tellitud\n(Klient on kurb)\n");
                return false;
            }
        }
        return false; // juhul kui mingid tingimused ei olnud taidetud returnib false
    }

    private static Kohv kasTegiKohvi(List<Kohv> kohvid, List<String> valitudKoostisosad) { // vaatab millise kohviga (kui uldse) matchivad kasutaja valitud koostisosad
        for (Kohv kohv : kohvid) {
            if (kohv.getKoostisosad().length == valitudKoostisosad.size()) {
                boolean sobib = true;
                for (String koostisosa : valitudKoostisosad) {
                    boolean leitud = false;
                    for (String k : kohv.getKoostisosad()) {
                        if (k.equals(koostisosa)) {
                            leitud = true;
                            break;
                        }
                    }
                    if (!leitud) {
                        sobib = false;
                        break;
                    }
                }
                if (sobib) {
                    return kohv;
                }
            }
        }
        return null;
    }
}
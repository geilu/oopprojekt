import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // kohvid
        Kohv espresso = new Kohv("Espresso", 3.80, new String[]{"espresso"});
        Kohv americano = new Kohv("Americano", 5.0, new String[]{"espresso", "kuum vesi"});
        Saiake kohvisai = new Saiake("Kohvisai", 1.5);
        Saiake moskvasai = new Saiake("Moskvasai", 1.8);

        //Loob listid ja lisab tooted nendesse
        ArrayList<Kohv> kohvimenuu = new ArrayList<>();
        ArrayList<Saiake> saiamenuu = new ArrayList<>();
        kohvimenuu.add(espresso);
        kohvimenuu.add(americano);
        saiamenuu.add(kohvisai);
        saiamenuu.add(moskvasai);


        Scanner sc = new Scanner(System.in);
        while (true) { // main program loop
            System.out.println("Valikud:\n1. Lõpeta programm\n2. Vaata menüüd\n3. Alusta tööpäevaga");
            String valik = sc.nextLine();
            switch (valik) {
                case "1":
                    System.out.println("programmi töö lõpetatakse");
                    return;
                case "2":
                    System.out.println("---Menüü---\n");
                    System.out.println("Saiad--->");
                    for (int i = 0; i < saiamenuu.size(); i++){
                        System.out.println(saiamenuu.get(i));
                    }
                    System.out.println("Joogid--->");
                    for (int i = 0; i < kohvimenuu.size(); i++) {
                        System.out.println(kohvimenuu.get(i));
                    }
                    break;
                case "3":
                    workday(kohvimenuu, saiamenuu); break;
                default:
                    System.out.println("proovi uuesti"); break;
            }
            System.out.println();
        }
    }

    public static void workday(ArrayList<Kohv> kohvimenuu, ArrayList<Saiake> saiamenuu) {
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
            System.out.println("Kliendil on piisavalt raha\n(Klient on õnnelik)");
        }else{
            System.out.println("Kliendil ei olnud piisavalt palju raha ja lahkus\n(Klient on kurb)");
        }
    }
}
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // kohvid
        Kohv espresso = new Kohv(3.80, "Espresso", new String[]{"espresso"});
        Kohv americano = new Kohv(5.0, "Americano", new String[]{"espresso", "kuum vesi"});

        ArrayList<Kohv> menuu = new ArrayList<>();
        menuu.add(espresso);
        menuu.add(americano);

        Scanner sc = new Scanner(System.in);
        while (true) { // main program loop
            System.out.println("Valikud:\n1. Lõpeta programm\n2. Vaata menüüd\n3. Alusta tööpäevaga");
            String valik = sc.nextLine();
            switch (valik) {
                case "1":
                    System.out.println("programmi töö lõpetatakse");
                    return;
                case "2":
                    System.out.println("---Menüü---");
                    for (int i = 0; i < menuu.size(); i++) {
                        System.out.println(menuu.get(i));
                    } break;
                case "3":
                    workday(menuu); break;
                default:
                    System.out.println("proovi uuesti"); break;
            }
            System.out.println();
        }
    }

    public static void workday(ArrayList<Kohv> menuu) {
        Random r = new Random();
        int idx = r.nextInt(menuu.size());
        String randomKohv = menuu.get(idx).getNimi();
        System.out.println("palun andke mulle " + randomKohv);
    }
}
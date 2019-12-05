import Automate.Automate;

import java.util.Scanner;

public class MonApplication {

    public static void main(String[] args) {
        String[][] smiley = {
                {null, ":", ";", null, null},
                {null, null, null, "=-", null},
                {null, null, null, "-", null},
                {null, null, null, null, "()"},
                {null, null, null, null, null}
        };

        String[][] hour = {
                {null, "01", "2", null, null, null, null},
                {null, null, null, "0123456789", null, null, null},
                {null, null, null, "0123", null, null, null},
                {null, null, null, null, ":", null, null},
                {null, null, null, null, null, "012345", null},
                {null, null, null, null, null, null, "0123456789"},
                {null, null, null, null, null, null, null},
        };
        boolean arret = false;
        Automate aut = new Automate(smiley);
        while (!arret) {
            int type = -1;
            arret = false;

            Scanner scanner = new Scanner(System.in);
            System.out.println("---------------Menu du TP-------------------");
            System.out.println("1. Smiley");
            System.out.println("2. Heure");
            System.out.println("3. Arrêt du programme");
            System.out.println("--------------------------------------------");
            System.out.print("Entrez le type de chaine à analyser: ");

            while (type <= 0 || type > 3) {

                type = scanner.nextInt();

            }

            switch (type) {
                case 1:
                    aut = new Automate(smiley);
                    break;
                case 2:
                    aut = new Automate(hour);
                    break;
                case 3:
                    arret = true;
                    break;
                default:
                    aut = new Automate(smiley);
                    break;
            }

            if (!arret) {
                System.out.print("Votre chaine: ");

                String chaine = scanner.next();

                System.out.println(String.format("Ta chaine est %s", aut.verify(chaine)));
            }
        }
    }
}

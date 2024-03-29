import Automate.Automate;
import java.util.ArrayList;
import java.util.List;
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
                {null, null, null, null, null, null, null}
        };

        String[][] date = new String[15][15];
        date[0][1] = "3"; date[0][2] = "012";
        date[1][3] = "1"; date[1][4] = "0";
        date[2][5] = "0123456789";
        date[3][6] = "/";
        date[4][7] = "/";
        date[5][8] = "/";
        date[6][9] = "0"; date[6][10] = "1";
        date[7][11] = "0"; date[7][12] = "1";
        date[8][12] = "1"; date[8][13] = "0";
        date[9][14] = "13579";
        date[10][14] = "02";
        date[11][14] = "13456789";
        date[12][14] = "012";
        date[13][14] = "123456789";

        String[][] annee = new String[8][8];
        annee[0][1] = "0"; annee[0][2] = "123456789";
        annee[1][3] = "0"; annee[1][4] = "123456789";
        annee[2][4] = "0123456789";
        annee[3][5] = "0"; annee[3][6] = "123456789";
        annee[4][6] = "0123456789";
        annee[5][7] = "123456789";
        annee[6][7] = "0123456789";

        String[][] mail = new String[6][6];
        mail[0][1] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWKYZ";
        mail[1][1] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWKYZ"; mail[1][2] = "@";
        mail[2][3] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWKYZ";
        mail[3][4] = "."; mail[3][3] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWKYZ";
        mail[4][5] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWKYZ";
        mail[5][4] = ".";

        String[][] monome = new String[5][5];
        monome[0][1] = "+-";
        monome[1][2] = "1"; monome[1][3] = "2"; monome[1][4] = "3456789";
        monome[2][4] = "0123456789";
        monome[3][4] = "012345";

        String[][] xCarre = new String[5][5];
        xCarre[0][1] = "X"; xCarre[1][2] = "*"; xCarre[2][3] = "*"; xCarre[3][4] = "2";

        boolean arret = false;
        Automate aut = new Automate(smiley);
        while (!arret) {
            int type = -1;
            arret = false;

            Scanner scanner = new Scanner(System.in);
            System.out.println("---------------Menu du TP-------------------");
            System.out.println("1. Smiley");
            System.out.println("2. Heure");
            System.out.println("3. Date");
            System.out.println("4. Email");
            System.out.println("5. Polynome");
            System.out.println("6. Arrêt du programme");
            System.out.println("--------------------------------------------");
            System.out.print("Entrez le type de chaine à analyser: ");

            while (type <= 0 || type > 6) {

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
                    ArrayList<Automate> list = new ArrayList<Automate>();
                    list.add(new Automate(date));
                    list.add(new Automate(annee));
                    aut = new Automate(list, "/");
                    break;
                case 4 :
                    aut = new Automate(mail);
                    break;
                case 5:
                    ArrayList<Automate> list1 = new ArrayList<Automate>();
                    list1.add(new Automate(monome));
                    list1.add(new Automate(xCarre));
                    Automate monomeCarre = new Automate(list1);
                    ArrayList<Automate> list2 = new ArrayList<Automate>();
                    list2.add(new Automate(monome));
                    list2.add(new Automate(monome));
                    Automate monomeInf = new Automate(list2, "X");
                    ArrayList<Automate> list3 = new ArrayList<Automate>();
                    list3.add(monomeCarre);
                    list3.add(monomeInf);
                    aut = new Automate(list3);
                    break;
                default:
                    arret = true;
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

package Automate;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Automate {

    private Etat E0;

    /**
     * Initialise l'automate avec un tableau multidimensionnel de String
     * Exemple pour un automate reconnaissant oui ou non :
     *              E0  E1  E2  E3 <-tab[]
     * tab[][]->E0
     *          E1  on
     *          E2      o
     *          E3          in
     * Le dernier état est toujours l'état final, il est initialisé avec une ligne à null
     * @param tab Le tableau de l'automate
     */
    public Automate(String[][] tab) {
        LinkedList<Etat> list = new LinkedList<Etat>();
        for (int i = 0; i < tab.length - 1; i++) {
            list.add(i,new EtatInter());
        }
        list.add(tab.length -1,new EtatFinal());

        for (int i = 0; i < tab.length - 1; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] != null)
                    list.get(i).addCondition(tab[i][j], list.get(j));
            }
        }

        E0 = list.get(0);
    }

    /**
     * Vérife la chaine
     * @param s la chaine
     * @return OK ou KO
     */
    public String verify(String s) {
        return E0.getChain(s);
    }
}
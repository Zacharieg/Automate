package Automate;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Automate {

    private Etat E0;
    private EtatFinal Ef;

    /**
     * Initialise l'automate avec un tableau multidimensionnel de String
     * Exemple pour un automate reconnaissant oui ou non :
     *              E0  E1  E2  E3  E4 <-tab[]
     * tab[][]->E0
     *          E1  on
     *          E2      o
     *          E3          in
     *          E4
     * Le dernier etat renvoi ok par défaut, mais peut renvoyer sur d'autres états
     * @param tab Le tableau de l'automate
     */
    public Automate(String[][] tab) {
        LinkedList<Etat> list = new LinkedList<Etat>();
        for (int i = 0; i < tab.length - 1; i++) {
            list.add(i,new EtatInter());
        }
        Ef = new EtatFinal();
        list.add(tab.length -1,Ef);

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] != null)
                    list.get(i).addCondition(tab[i][j], list.get(j));
            }
        }

        E0 = list.get(0);
    }

    public Automate (List<Automate> list) {
        E0 = list.get(0).getE0();
        Ef = list.get(list.size()-1).getEf();
        for (int i = 0; i < list.size() - 1; i++) {
         list.get(i).getEf().addSuite(list.get(i+1).getE0());
        }
    }

    public Automate (List<Automate> list, String separateur) {
        E0 = list.get(0).getE0();
        Ef = list.get(list.size()-1).getEf();
        for (int i = 0; i < list.size() - 1; i++) {
            Etat e = new EtatInter();
            e.addCondition(separateur, list.get(i+1).getE0());
            list.get(i).getEf().addSuite(e);
        }
    }

    /**
     * Vérife la chaine
     * @param s la chaine
     * @return OK ou KO
     */
    public String verify(String s) {
        return E0.getChain(s);
    }

    public Etat getE0() {
        return E0;
    }

    public EtatFinal getEf() {
        return Ef;
    }
}
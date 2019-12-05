package Automate;

import java.util.ArrayList;

public class EtatFinal implements Etat {

    @Override
    public void addCondition(String c, Etat e) {
        throw new RuntimeException("Vous ne pouvez pas ajouter une condition");
    }

    @Override
    public String getChain(String chaine) {
        return "OK";
    }
}

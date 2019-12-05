package Automate;

import java.util.HashMap;

public interface Etat {


    /**
     * Ajoute une sortie possible à l'état pour un autre Etat
     * @param c les caractères possibles
     * @param e l'état correspondant
     */
    public void addCondition(String c, Etat e);

    /**
     * Analyse la chaine de caractère
     * @param chaine la chaine à analyser
     * @return OK ou KO
     */
    public String getChain(String chaine);

}

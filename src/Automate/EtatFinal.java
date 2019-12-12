package Automate;

import java.util.ArrayList;
import java.util.HashMap;

public class EtatFinal implements Etat {

    private Etat suite;
    private HashMap<Character, Etat> map;

    public EtatFinal() {
        map = new HashMap<Character, Etat>();
    }

    @Override
    public void addCondition(String c, Etat e) {
        for (int i = 0; i < c.length(); i++) {
            map.put(c.charAt(i), e);
        }
    }

    public void addSuite(Etat e) {
        suite = e;
    }

    @Override
    public String getChain(String chaine) {
        String ret = "OK";
        if (chaine != null) {
            if (suite != null)
                ret = suite.getChain(chaine);
            if (chaine.length() > 1) {
                Character c = chaine.charAt(0);
                if (map.containsKey(c)) {
                    ret = map.get(c).getChain(chaine.substring(1, chaine.length()));
                }
            } else if (chaine.length() == 1)
                if (map.containsKey(chaine.charAt(0))) {
                    ret = map.get(new String()).getChain(chaine.substring(1, chaine.length()));
                }
        }
        return ret;
    }
}

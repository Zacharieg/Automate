package Automate;

import java.util.HashMap;

public class EtatInter implements Etat {

    private HashMap<Character, Etat> map;

    public EtatInter(HashMap<Character, Etat> map) {
        this.map = map;
    }

    public EtatInter() {
        this.map = new HashMap<Character, Etat>();
    }

    @Override
    public void addCondition(String c, Etat e) {
        for (int i = 0; i < c.length(); i++) {
            map.put(c.charAt(i), e);
        }
    }

    @Override
    public String getChain(String chaine) {
        String ret = "KO";
        if (chaine != null) {
            if (chaine.length() > 0) {
                Character c = chaine.charAt(0);
                if (map.containsKey(c)) {
                    ret = map.get(c).getChain(chaine.substring(1, chaine.length()));
                }
            }
        }
        return ret;
    }
}

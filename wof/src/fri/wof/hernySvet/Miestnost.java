package fri.wof.hernySvet;

import fri.wof.predmety.IPredmet;

import java.util.HashMap;

public class Miestnost {
    private final String popisMiestnosti;
    private final HashMap<String, IPredmet> predmety;

    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.predmety = new HashMap<String, IPredmet>();
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public void vlozPredmet(IPredmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }

    public void vypisZoznamPredmetov() {
        if (!this.predmety.isEmpty()) {
            System.out.println("Nasiel si totokaj:");
            for (String nazov : this.predmety.keySet()) {
                System.out.printf("- %s%n", nazov);
            }
        } else {
            System.out.println("Nist si nenasiel");
        }
    }

    public IPredmet odoberPredmet(String nazovPredmetu) {
        return this.predmety.remove(nazovPredmetu);
    }

    public Miestnost getMiestnostVSmere(String smer) {
        return null;
    }

    public boolean mozeVojst(Hrac hrac) {
        return true;
    }

    public void vypisPopisMiestnosti() {
        System.out.println(this.popisMiestnosti);
    }
}

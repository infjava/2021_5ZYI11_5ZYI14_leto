package fri.wof.hernySvet;

import fri.wof.npc.Npc;
import fri.wof.predmety.IPredmet;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class Miestnost implements Serializable {
    private final String popisMiestnosti;
    private final HashMap<String, IPredmet> predmety;
    private final HashMap<String, Npc> npccka;

    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.predmety = new HashMap<String, IPredmet>();
        this.npccka = new HashMap<String, Npc>();
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

    public Miestnost getMiestnostVSmere(String smer) throws NespravnyVychodException {
        throw new NespravnyVychodException();
    }

    public boolean mozeVojst(Hrac hrac) {
        return true;
    }

    public void vypisPopisMiestnosti() {
        System.out.println(this.popisMiestnosti);
    }

    public void postavNpc(Npc npc) {
        this.npccka.put(npc.getMeno(), npc);
    }

    protected void vypisZoznamNpc() {
        this.vypisZoznamKlucov("NPC", this.npccka.keySet());
    }

    protected void vypisZoznamKlucov(String nadpis, Set<String> kluce) {
        if (!kluce.isEmpty()) {
            System.out.printf("%s: ", nadpis);
            for (String kluc : kluce) {
                System.out.printf("%s ", kluc);
            }
            System.out.println();
        }
    }

    public Npc getNpc(String menoNpc) {
        return this.npccka.get(menoNpc);
    }
}

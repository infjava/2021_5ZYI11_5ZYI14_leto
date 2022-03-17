package fri.wof.hernySvet;

import fri.wof.predmety.IPredmet;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Trieda fri.wof.hernySvet.Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private final String popisMiestnosti;
    private final TreeMap<String, Miestnost> vychody;
    private final HashMap<String, IPredmet> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new TreeMap<>();
        this.predmety = new HashMap<String, IPredmet>();
    }

    public void nastavVychod(Miestnost miestnost, String smer) {
        if (miestnost != null) {
            this.vychody.put(smer, miestnost);
        }
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    void vypisPopisMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (String smer : this.vychody.keySet()) {
            System.out.printf("%s ", smer);
        }
        System.out.println();
    }

    Miestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
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
}

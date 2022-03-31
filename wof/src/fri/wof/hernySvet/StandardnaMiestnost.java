package fri.wof.hernySvet;

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
public class StandardnaMiestnost extends Miestnost {
    private final TreeMap<String, Miestnost> vychody;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public StandardnaMiestnost(String popis) {
        super(popis);
        this.vychody = new TreeMap<>();
    }

    public void nastavVychod(Miestnost miestnost, String smer) {
        if (miestnost != null) {
            this.vychody.put(smer, miestnost);
        }
    }

    public void zrusVychod(String smer) {
        this.vychody.remove(smer);
    }

    public void vypisPopisMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        this.vypisZoznamKlucov("Vychody", this.vychody.keySet());
        this.vypisZoznamNpc();
    }

    public Miestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    public boolean mozeVojst(Hrac hrac) {
        return true;
    }
}

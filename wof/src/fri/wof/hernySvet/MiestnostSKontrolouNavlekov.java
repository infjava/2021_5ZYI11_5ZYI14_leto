package fri.wof.hernySvet;

import fri.wof.predmety.IPredmet;
import fri.wof.predmety.Navleky;

public class MiestnostSKontrolouNavlekov extends Miestnost {
    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne
     * charakterizuje.
     *
     * @param popis text popisu miestnosti.
     */
    public MiestnostSKontrolouNavlekov(String popis) {
        super(popis);
    }

    @Override
    public boolean mozeVojst(Hrac hrac) {
        IPredmet navleky = hrac.getPredmet("navleky");
        return navleky != null && ((Navleky)navleky).getObute();
    }
}

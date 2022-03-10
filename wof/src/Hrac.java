import java.util.ArrayList;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private final ArrayList<String> inventar;
    private Miestnost aktualnaMiestnost;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new ArrayList<String>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    void posunSa(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.aktualnaMiestnost.vypisPopisMiestnosti();
        }
    }

    public void zdvihniPredmet(String nazovPredmetu) {
        if (this.aktualnaMiestnost.odoberPredmet(nazovPredmetu)) {
            this.inventar.add(nazovPredmetu);
        } else {
            System.out.println("Ako kukam, tak kukam, taky predmet nevidim");
        }
    }

    public void polozPredmet(String nazovPredmetu) {
        if (this.inventar.remove(nazovPredmetu)) {
            this.aktualnaMiestnost.vlozPredmet(nazovPredmetu);
        } else {
            System.out.println("Taky predmet veru nemas");
        }
    }
}

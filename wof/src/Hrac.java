import java.util.HashMap;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private final HashMap<String, Predmet> inventar;
    private Miestnost aktualnaMiestnost;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
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
        Predmet predmet = this.aktualnaMiestnost.odoberPredmet(nazovPredmetu);
        if (predmet != null) {
            this.inventar.put(predmet.getNazov(), predmet);
        } else {
            System.out.println("Ako kukam, tak kukam, taky predmet nevidim");
        }
    }

    public void polozPredmet(String nazovPredmetu) {
        Predmet predmet = this.inventar.remove(nazovPredmetu);
        if (predmet != null) {
            this.aktualnaMiestnost.vlozPredmet(predmet);
        } else {
            System.out.println("Taky predmet veru nemas");
        }
    }

    public void pouziPredmet(String nazovPredmetu) {
        Predmet predmet = this.inventar.get(nazovPredmetu);
        if (predmet != null) {
            predmet.pouzi();
        } else {
            System.out.println("Taky predmet veru nemas");
        }
    }
}

package fri.wof.hernySvet;

import fri.wof.npc.CastRozhovoru;
import fri.wof.npc.Npc;
import fri.wof.predmety.IPredmet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private final HashMap<String, IPredmet> inventar;
    private Miestnost aktualnaMiestnost;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void posunSa(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else if (!novaMiestnost.mozeVojst(this)) {
            System.out.println("Nemozes vojst");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.aktualnaMiestnost.vypisPopisMiestnosti();
        }
    }

    public void zdvihniPredmet(String nazovPredmetu) {
        IPredmet predmet = this.aktualnaMiestnost.odoberPredmet(nazovPredmetu);
        if (predmet != null) {
            this.inventar.put(predmet.getNazov(), predmet);
        } else {
            System.out.println("Ako kukam, tak kukam, taky predmet nevidim");
        }
    }

    public void polozPredmet(String nazovPredmetu) {
        IPredmet predmet = this.inventar.remove(nazovPredmetu);
        if (predmet != null) {
            this.aktualnaMiestnost.vlozPredmet(predmet);
        } else {
            System.out.println("Taky predmet veru nemas");
        }
    }

    public void pouziPredmet(String nazovPredmetu) {
        IPredmet predmet = this.inventar.get(nazovPredmetu);
        if (predmet != null) {
            predmet.pouzi(this);
        } else {
            System.out.println("Taky predmet veru nemas");
        }
    }

    public IPredmet getPredmet(String nazovPredmetu) {
        return this.inventar.get(nazovPredmetu);
    }

    public void porozpravajSaSNpc(String menoNpc) {
        Scanner vstup = new Scanner(System.in);

        Npc npc = this.aktualnaMiestnost.getNpc(menoNpc);

        if (npc == null) {
            System.out.printf("Npc %s nikde nevidis%n", menoNpc);
            return;
        }

        CastRozhovoru korenRozhovoru = npc.getKorenRozhovoru();
        korenRozhovoru.vypis();

        System.out.print("Vyber: ");
        int moznost = vstup.nextInt();

        CastRozhovoru nasledujucaCast = korenRozhovoru.getNasledujucaCast(moznost);
        nasledujucaCast.vypis();
    }
}

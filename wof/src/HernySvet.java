/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class HernySvet {
    private final Miestnost startovaciaMiestnost;

    /**
     * Vytvori mapu hry - miestnosti.
     */
    public HernySvet() {
        // vytvorenie miestnosti
        Miestnost sietovyLabak = new Miestnost("sietovy labak - tu robime pokusy na pocitacovej sieti; hadam nezhodime cely internet");
        Miestnost vonok = new Miestnost("vonok - i want to be free");
        Miestnost jedalen = new Miestnost("jedalen - prave davaju na obed uho - univerzalnu hnedu omacku. Mnam");
        Miestnost b2 = new Miestnost("b2 - skupina studentov prave maka na novych vlastnostiach hry world of fri");
        Miestnost vytah = new Miestnost("vytah - do tohto by nikto pricetny nesadol. Takze ja mozem");
        Miestnost c9 = new Miestnost("c9 - prave prebieha prednaska z matiky, aspon sa nieco naucim");
        Miestnost c = new Miestnost("c - chodba v podzemi, uz len najst dalsi level a idem na Diabla");
        Miestnost atrium = new Miestnost("atrium - dnes vystavuju Picasa");
        Miestnost b = new Miestnost("b - dlha temna chodba");
        Miestnost vratnica = new Miestnost("vratnica - hlavny vstup na fakultu");
        Miestnost a = new Miestnost("a - po chodbe sa siria vone z jedalne a z wc");
        Miestnost wc = new Miestnost("wc - radsej ani nepoviem, co vidim");

        sietovyLabak.nastavVychod(vytah, "vytah");

        vonok.nastavVychod(vratnica, "vratnica");
        vonok.nastavVychod(jedalen, "jedalen");

        jedalen.nastavVychod(vonok, "vonok");
        jedalen.nastavVychod(c, "c");

        b2.nastavVychod(b, "b");

        vytah.nastavVychod(sietovyLabak, "sietovyLabak");
        vytah.nastavVychod(b, "b");

        c9.nastavVychod(c, "c");

        c.nastavVychod(c9, "c9");
        c.nastavVychod(jedalen, "jedalen");
        c.nastavVychod(atrium, "atrium");
        c.nastavVychod(a, "a");

        atrium.nastavVychod(c, "c");

        b.nastavVychod(b2, "b2");
        b.nastavVychod(vytah, "vytah");
        b.nastavVychod(vratnica, "vratnica");

        vratnica.nastavVychod(b, "b");
        vratnica.nastavVychod(a, "a");
        vratnica.nastavVychod(vonok, "vonok");

        vratnica.vlozPredmet(new Predmet("kluce"));
        vratnica.vlozPredmet(new Predmet("isic"));
        vratnica.vlozPredmet(new Predmet("navleky"));

        a.nastavVychod(c, "c");
        a.nastavVychod(vratnica, "vratnica");
        a.nastavVychod(wc, "wc");

        wc.nastavVychod(a, "a");

        this.startovaciaMiestnost = vratnica;
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}

package fri.wof.hernySvet;

import fri.wof.npc.CastRozhovoru;
import fri.wof.npc.Npc;
import fri.wof.npc.Odpoved;
import fri.wof.predmety.Navleky;
import fri.wof.predmety.PortalGun;
import fri.wof.predmety.Predmet;

import java.io.Serializable;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class HernySvet implements Serializable {
    private final StandardnaMiestnost startovaciaMiestnost;

    /**
     * Vytvori mapu hry - miestnosti.
     */
    public HernySvet() {
        // vytvorenie miestnosti
        StandardnaMiestnost sietovyLabak = new StandardnaMiestnost("sietovy labak - tu robime pokusy na pocitacovej sieti; hadam nezhodime cely internet");
        StandardnaMiestnost vonok = new StandardnaMiestnost("vonok - i want to be free");
        StandardnaMiestnost jedalen = new StandardnaMiestnost("jedalen - prave davaju na obed uho - univerzalnu hnedu omacku. Mnam");
        StandardnaMiestnost b2 = new MiestnostSKontrolouNavlekov("b2 - skupina studentov prave maka na novych vlastnostiach hry world of fri");
        Vytah vytah = new Vytah("vytah - do tohto by nikto pricetny nesadol. Takze ja mozem");
        StandardnaMiestnost c9 = new StandardnaMiestnost("c9 - prave prebieha prednaska z matiky, aspon sa nieco naucim");
        StandardnaMiestnost c = new StandardnaMiestnost("c - chodba v podzemi, uz len najst dalsi level a idem na Diabla");
        StandardnaMiestnost atrium = new StandardnaMiestnost("atrium - dnes vystavuju Picasa");
        StandardnaMiestnost b = new StandardnaMiestnost("b - dlha temna chodba");
        StandardnaMiestnost vratnica = new StandardnaMiestnost("vratnica - hlavny vstup na fakultu");
        StandardnaMiestnost a = new StandardnaMiestnost("a - po chodbe sa siria vone z jedalne a z wc");
        StandardnaMiestnost wc = new StandardnaMiestnost("wc - radsej ani nepoviem, co vidim");

        sietovyLabak.nastavVychod(vytah, "vytah");

        vonok.nastavVychod(vratnica, "vratnica");
        vonok.nastavVychod(jedalen, "jedalen");

        jedalen.nastavVychod(vonok, "vonok");
        jedalen.nastavVychod(c, "c");

        b2.nastavVychod(b, "b");

        vytah.pridajPoschodie(b);
        vytah.pridajPoschodie(sietovyLabak);

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
        vratnica.vlozPredmet(new Navleky());
        vratnica.vlozPredmet(new PortalGun());

        CastRozhovoru vratnickaF = new CastRozhovoru("12, vratane vytahu.", new Odpoved[0]);

        CastRozhovoru vratnickaE = new CastRozhovoru("10:59", new Odpoved[0]);

        CastRozhovoru vratnickaD = new CastRozhovoru("12:59", new Odpoved[0]);

        CastRozhovoru vratnickaC = new CastRozhovoru(
            "CEST, alebo UTC?",
            new Odpoved[] {
                new Odpoved("CEST", vratnickaD),
                new Odpoved("UTC", vratnickaE)
            }
        );

        CastRozhovoru vratnickaB = new CastRozhovoru("To musite ist za bufetarkou", new Odpoved[0]);

        CastRozhovoru vratnickaA = new CastRozhovoru(
            "Dobry den. Co si prajete?",
            new Odpoved[] {
                new Odpoved("Dobry den, jednu horalku", vratnickaB),
                new Odpoved("Dobry den, aky je cas?", vratnickaC),
                new Odpoved("Dobry den, kolko je na skole miestnosti?", vratnickaF)
            }
        );
        vratnica.postavNpc(new Npc("vratnicka", vratnickaA));

        a.nastavVychod(c, "c");
        a.nastavVychod(vratnica, "vratnica");
        a.nastavVychod(wc, "wc");

        wc.nastavVychod(a, "a");

        this.startovaciaMiestnost = vratnica;
    }

    public StandardnaMiestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}

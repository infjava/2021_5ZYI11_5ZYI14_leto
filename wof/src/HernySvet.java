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
        Miestnost terasa = new Miestnost("terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula");
        Miestnost bufet = new Miestnost("bufet");
        Miestnost labak = new Miestnost("pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria spravcu pocitacoveho laboratoria");

        // inicializacia miestnosti = nastavenie vychodov
        terasa.nastavVychod(aula, "vychod");
        terasa.nastavVychod(labak, "juh");
        terasa.nastavVychod(bufet, "zapad");
        aula.nastavVychod(terasa, "zapad");
        bufet.nastavVychod(terasa, "vychod");
        labak.nastavVychod(terasa, "sever");
        labak.nastavVychod(kancelaria, "vychod");
        kancelaria.nastavVychod(labak, "zapad");

        this.startovaciaMiestnost = terasa;
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}

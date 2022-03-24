import fri.wof.hernySvet.Hrac;
import fri.wof.hernySvet.Miestnost;
import fri.wof.hernySvet.StandardnaMiestnost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
class HracTest {

    private Hrac hrac;
    private StandardnaMiestnost aktualna;
    private Miestnost susedna;

    @BeforeEach
    void setUp() {
        this.aktualna = new StandardnaMiestnost("aktualna");
        this.susedna = new StandardnaMiestnost("susedna");
        this.aktualna.nastavVychod(this.susedna, "sever");
        this.aktualna.nastavVychod(null, "vychod");
        this.aktualna.nastavVychod(null, "juh");
        this.aktualna.nastavVychod(null, "zapad");
        this.hrac = new Hrac(this.aktualna);
    }

    @Test
    void getAktualnaMiestnost() {
        Assertions.assertSame(this.aktualna, this.hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaSpravne() {
        this.hrac.posunSa("sever");

        Assertions.assertSame(this.susedna, this.hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaDoNespravnehoSmeru() {
        this.hrac.posunSa("vychod");

        Assertions.assertSame(this.aktualna, this.hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaDoNeexistujucehoSmeru() {
        this.hrac.posunSa("severozapad");

        Assertions.assertSame(this.aktualna, this.hrac.getAktualnaMiestnost());
    }
}

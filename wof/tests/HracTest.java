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
    private Miestnost aktualna;
    private Miestnost susedna;

    @BeforeEach
    void setUp() {
        this.aktualna = new Miestnost("aktualna");
        this.susedna = new Miestnost("susedna");
        this.aktualna.nastavVychody(this.susedna, null, null, null);
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

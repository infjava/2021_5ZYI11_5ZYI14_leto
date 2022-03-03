import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
class HracTest {

    @Test
    void posunSaSpravne() {
        Miestnost aktualna = new Miestnost("aktualna");
        Miestnost susedna = new Miestnost("susedna");
        aktualna.nastavVychody(susedna, null, null, null);
        Hrac hrac = new Hrac(aktualna);

        hrac.posunSa("sever");

        Assertions.assertSame(susedna, hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaDoNespravnehoSmeru() {
        Miestnost aktualna = new Miestnost("aktualna");
        Miestnost susedna = new Miestnost("susedna");
        aktualna.nastavVychody(susedna, null, null, null);
        Hrac hrac = new Hrac(aktualna);

        hrac.posunSa("vychod");

        Assertions.assertSame(aktualna, hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaDoNeexistujucehoSmeru() {
        Miestnost aktualna = new Miestnost("aktualna");
        Miestnost susedna = new Miestnost("susedna");
        aktualna.nastavVychody(susedna, null, null, null);
        Hrac hrac = new Hrac(aktualna);

        hrac.posunSa("severozapad");

        Assertions.assertSame(aktualna, hrac.getAktualnaMiestnost());
    }
}

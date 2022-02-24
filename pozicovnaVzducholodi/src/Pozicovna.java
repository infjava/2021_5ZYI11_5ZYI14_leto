/**
 * Created by IntelliJ IDEA.
 * User: janik
 * Date: 24. 2. 2022
 * Time: 16:26
 */
public class Pozicovna {
    private final Flotila flotila;

    public Pozicovna() {
        this.flotila = new Flotila();
    }

    public static void main(String[] args) {
        Pozicovna.vytvorTestovaciuPozicovnu().hlavneMenu();
    }

    public void hlavneMenu() {

    }

    public static Pozicovna vytvorTestovaciuPozicovnu() {
        Pozicovna pozicovna = new Pozicovna();

        pozicovna.vytvorVzducholod("Imperator Altair", Konstrukcia.VYSTUZENA, 100, 1);
        pozicovna.vytvorVzducholod("Imperator Deneb", Konstrukcia.VYSTUZENA, 85, 1);
        pozicovna.vytvorVzducholod("Rex Antares", Konstrukcia.POLOVYSTUZENA, 20, 3);
        pozicovna.vytvorVzducholod("Dux Regulus", Konstrukcia.NEVYSTUZENA, 5, 5);
        pozicovna.vytvorVzducholod("Dominus Alcor", Konstrukcia.HYBRIDNA, 150, 1);
        pozicovna.vytvorVzducholod("Dominus Mizar", Konstrukcia.HYBRIDNA, 100, 1);

        return pozicovna;
    }

    private void vytvorVzducholod(String nazov, Konstrukcia konstrukcia, int nosnost, int pocet) {
        for (int i = 0; i < pocet; i++) {
            this.flotila.vytvorVzducholod(konstrukcia, nazov, nosnost);
        }
    }
}

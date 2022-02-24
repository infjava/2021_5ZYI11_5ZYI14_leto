import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: janik
 * Date: 24. 2. 2022
 * Time: 16:26
 */
public class Pozicovna {
    private final Flotila flotila;
    private final Scanner scanner;

    public Pozicovna() {
        this.flotila = new Flotila();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Pozicovna.vytvorTestovaciuPozicovnu().hlavneMenu();
    }

    public void hlavneMenu() {
        for (;;) {
            System.out.println("HLAVNE MENU\n" +
                    "P - pozicanie vzducholode\n" +
                    "V - vratenie vzducholode\n" +
                    "O - oprava vzducholode\n" +
                    "F - vypis flotily\n" +
                    "K - koniec");

            String vstup = this.scanner.nextLine();

            switch (vstup) {
                case "P":
                    this.podmenuPozicanieVzducholode();
                    break;
                case "V":
                    this.podmenuVratenieVzducholode();
                    break;
                case "O":
                    this.podmenuOpravaVzducholode();
                    break;
                case "F":
                    this.podmenuVypisFlotily();
                    break;
                case "K":
                    return;
            }
        }
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

    private void podmenuPozicanieVzducholode() {
        System.out.println("POZICANIE VZDUCHOLODE");

        System.out.print("Zadajte pozadovanu nosnost ");
        int nosnost = this.scanner.nextInt();

        System.out.println("Zadajte pozadovanu konstrukciu");
        for (Konstrukcia konstrukcia : Konstrukcia.values()) {
            System.out.println(String.format("\t%d: %s", konstrukcia.ordinal(), konstrukcia.toString()));
        }
        System.out.println("\tInak volba: nezalezi na konstrukcii");
        System.out.print("\nVasa volba: ");
        int typKonstrukcie = this.scanner.nextInt();
        Konstrukcia konstrukcia = typKonstrukcie >= 0 && typKonstrukcie < Konstrukcia.values().length ? Konstrukcia.values()[typKonstrukcie] : null;

        System.out.print("Iba dostupne vzducholode? (1 = ano, inak nie)");
        boolean ibaDostupna = this.scanner.nextInt() == 1;

        Vzducholod vzducholod = this.flotila.najdiVzducholod(nosnost, konstrukcia, ibaDostupna);
        if (vzducholod != null && vzducholod.pozicka()) {
            System.out.println(vzducholod.toString() + " uspesne pozicana!");
        } else {
            System.out.println(String.format("Vzducholod s pozadovanymi vlastnostami sa nepodarilo pozicat, lebo vzducholod s danymi vlastnostami nie je k dispozicii!"));
        }

        this.scanner.nextLine();
    }

    private void podmenuVratenieVzducholode() {
        System.out.println("VRATENIE VZDUCHOLODE");

        System.out.print("Zadajte ID vzducholode, ktore chcete vratit ");
        int id = this.scanner.nextInt();

        Vzducholod vzducholod = this.flotila.najdiVzducholod(id);
        if (vzducholod != null && vzducholod.navrat()) {
            System.out.println(vzducholod.toString() + " uspesne vratena!");
        } else {
            System.out.println(String.format("Vzducholod s pozadovanymi vlastnostami sa nepodarilo vratit, lebo %s!",
                vzducholod == null ? "vzducholod s danym ID neexistuje" : "vzducholod nie je pozicana"));
        }

        this.scanner.nextLine();
    }

    private void podmenuOpravaVzducholode() {
        System.out.println("OPRAVA VZDUCHOLODE");

        System.out.print("Zadajte ID vzducholode, ktore chcete vratit ");
        int id = this.scanner.nextInt();

        Vzducholod vzducholod = this.flotila.najdiVzducholod(id);
        if (vzducholod != null && vzducholod.oprava()) {
            System.out.println(vzducholod.toString() + " uspesne vratena!");
        } else {
            System.out.println(String.format("Vzducholod s pozadovanymi vlastnostami sa nepodarilo opravit, lebo %s!",
                vzducholod == null ? "vzducholod s danym ID neexistuje" : "vzducholod nie je potrebne opravit"));
        }

        this.scanner.nextLine();
    }

    private void podmenuVypisFlotily() {
        System.out.println("VYPIS FLOTILY");

        System.out.println("Zadajte pozadovany stav");
        for (Stav stav : Stav.values()) {
            System.out.println(String.format("\t%d: %s", stav.ordinal(), stav.toString()));
        }
        System.out.println("\tInak volba: nezalezi na stave");
        System.out.print("\nVasa volba: ");
        int typStavu = this.scanner.nextInt();
        Stav stav = typStavu >= 0 && typStavu < Stav.values().length ? Stav.values()[typStavu] : null;

        this.flotila.vypisVzducholode(stav);

        this.scanner.nextLine();
    }

    private void vytvorVzducholod(String nazov, Konstrukcia konstrukcia, int nosnost, int pocet) {
        for (int i = 0; i < pocet; i++) {
            this.flotila.vytvorVzducholod(konstrukcia, nazov, nosnost);
        }
    }
}

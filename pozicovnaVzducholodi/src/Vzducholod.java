/**
 * 24. 2. 2022 - 16:26
 *
 * @author janik
 */
public class Vzducholod {
    private final int id;
    private final Konstrukcia konstrukcia;
    private final String nazov;
    private final int nosnost;
    private int pocetPozicani;
    private Stav stav;

    public Vzducholod(int id, Konstrukcia konstrukcia, String nazov, int nosnost) {

        this.id = id;
        this.konstrukcia = konstrukcia;
        this.nazov = nazov;
        this.nosnost = nosnost;
        this.pocetPozicani = 0;

        this.stav = Stav.VOLNA;
    }

    public int getId() {
        return this.id;
    }

    public Konstrukcia getKonstrukcia() {
        return this.konstrukcia;
    }

    public String getNazov() {
        return this.nazov;
    }

    public int getNosnost() {
        return this.nosnost;
    }

    public boolean pozicka() {
        if (this.stav == Stav.VOLNA) {
            this.stav = Stav.POZICANA;
            this.pocetPozicani++;
            return true;
        }
        return false;
    }

    public boolean navrat() {
        return false;
    }

    public boolean oprava() {
        return false;
    }

    public Stav getStav() {
        return this.stav;
    }

    @Override
    public String toString() {
        return "Vzducholod{" +
                "id=" + this.id +
                ", konstrukcia=" + this.konstrukcia +
                ", nazov='" + this.nazov + '\'' +
                ", nosnost=" + this.nosnost +
                '}';
    }
}

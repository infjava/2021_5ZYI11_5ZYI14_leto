/**
 * 24. 2. 2022 - 16:26
 *
 * @author janik
 */
public class Vzducholod {
    private static final int SERVIS_PO_KOLKYCH_POZICANIACH = 5;
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
        if (this.stav == Stav.POZICANA) {
            if (this.pocetPozicani >= Vzducholod.SERVIS_PO_KOLKYCH_POZICANIACH) {
                this.stav = Stav.V_SERVISE;
                this.pocetPozicani = 0;
            } else {
                this.stav = Stav.VOLNA;
            }
            return true;
        }
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

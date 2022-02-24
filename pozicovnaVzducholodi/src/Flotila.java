import java.util.ArrayList;

/**
 * 24. 2. 2022 - 16:26
 *
 * @author janik
 */
public class Flotila {
    private final ArrayList<Vzducholod> vzducholode;
    private int posledneId;

    public Flotila() {
        this.vzducholode = new ArrayList<Vzducholod>();
        this.posledneId = 0;
    }

    public void vytvorVzducholod(Konstrukcia konstrukcia, String nazov, int nosnost) {
        this.posledneId++;
        this.vzducholode.add(new Vzducholod(this.posledneId, konstrukcia, nazov, nosnost));
    }

    public Vzducholod najdiVzducholod(int nosnost, Konstrukcia konstrukcia, boolean ibaDostupna) {
        return null;
    }

    public Vzducholod najdiVzducholod(int id) {
        return null;
    }

    public void vypisVzducholode(Stav stav) {

    }
}

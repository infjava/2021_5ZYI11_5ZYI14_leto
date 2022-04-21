package fri.wof.npc;

import java.io.Serializable;

public class Odpoved implements Serializable {
    private final String replika;
    private final CastRozhovoru nasledujucaCast;

    public Odpoved(String replika, CastRozhovoru nasledujucaCast) {
        this.replika = replika;
        this.nasledujucaCast = nasledujucaCast;
    }

    public String getReplika() {
        return this.replika;
    }

    public CastRozhovoru getNasledujucaCast() {
        return this.nasledujucaCast;
    }
}

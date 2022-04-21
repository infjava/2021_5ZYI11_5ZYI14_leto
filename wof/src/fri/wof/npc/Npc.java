package fri.wof.npc;

import java.io.Serializable;

public class Npc implements Serializable {
    private final String meno;
    private final CastRozhovoru korenRozhovoru;

    public Npc(String meno, CastRozhovoru korenRozhovoru) {
        this.meno = meno;
        this.korenRozhovoru = korenRozhovoru;
    }

    public String getMeno() {
        return this.meno;
    }

    public CastRozhovoru getKorenRozhovoru() {
        return this.korenRozhovoru;
    }
}

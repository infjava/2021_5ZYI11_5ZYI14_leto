package fri.wof.npc;

public class Odpoved {
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

package fri.wof.npc;

import java.io.Serializable;

public class CastRozhovoru implements Serializable {
    private final String replika;
    private final Odpoved[] odpovede;

    public CastRozhovoru(String replika, Odpoved[] odpovede) {
        this.replika = replika;
        this.odpovede = odpovede;
    }

    public void vypis() {
        System.out.println(this.replika);

        for (int i = 0; i < this.odpovede.length; i++) {
            System.out.printf("%d) %s%n", i + 1, this.odpovede[i].getReplika());
        }
    }

    public CastRozhovoru getNasledujucaCast(int moznost) {
        return this.odpovede[moznost - 1].getNasledujucaCast();
    }

    public boolean maOdpovede() {
        return this.odpovede.length > 0;
    }
}

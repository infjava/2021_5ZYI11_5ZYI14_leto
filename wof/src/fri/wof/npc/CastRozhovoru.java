package fri.wof.npc;

public class CastRozhovoru {
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
}

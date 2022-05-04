package fri.zoo;

public class Klietka {
    private Lev lev;

    public void vlozZviera(Lev lev) {

        this.lev = lev;
    }

    public void vypis() {
        if (this.lev == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.printf("V klietke je %s%n", this.lev);
        }
    }
}

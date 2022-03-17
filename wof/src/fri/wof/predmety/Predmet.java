package fri.wof.predmety;

public class Predmet implements IPredmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouzi() {
        System.out.printf("fri.wof.predmety.Predmet %s sa neda pouzit%n", this.nazov);
    }
}

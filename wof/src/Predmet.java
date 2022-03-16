public class Predmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void pouzi() {
        if (this.nazov.equals("navleky")) {
            System.out.println("Obul si si navleky");
        } else {
            System.out.printf("Predmet %s sa neda pouzit%n", this.nazov);
        }
    }
}

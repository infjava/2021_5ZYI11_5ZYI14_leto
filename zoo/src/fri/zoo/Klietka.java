package fri.zoo;

public class Klietka<E extends Zviera> {
    private E zviera;

    public void vlozZviera(E zviera) {

        this.zviera = zviera;
    }

    public String getTextNaCedulke() {
        if (this.zviera == null) {
            return "Prazdna klietka";
        } else {
            return String.format("Zviera s menom %s", this.zviera.getMeno());
        }
    }

    public void vypis() {
        if (this.zviera == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.printf("V klietke je %s%n", this.zviera);
        }
    }
}

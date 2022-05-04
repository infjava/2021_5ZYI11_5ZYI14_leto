package fri.zoo;

public class Klietka<E> {
    private E zviera;

    public void vlozZviera(E zviera) {

        this.zviera = zviera;
    }

    public void vypis() {
        if (this.zviera == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.printf("V klietke je %s%n", this.zviera);
        }
    }
}
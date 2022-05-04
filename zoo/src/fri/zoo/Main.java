package fri.zoo;

public class Main {

    public static void main(String[] args) {
	    Lev lev = new Lev();
        Klietka klietkaNaLeva = new Klietka();
        klietkaNaLeva.vlozZviera(lev);
        klietkaNaLeva.vypis();

        Mys mys = new Mys();
        Klietka klietkaNaMys = new Klietka();
        klietkaNaMys.vlozZviera(mys);
        klietkaNaMys.vypis();
    }
}

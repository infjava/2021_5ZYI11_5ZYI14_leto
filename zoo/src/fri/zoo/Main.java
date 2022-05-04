package fri.zoo;

public class Main {

    public static void main(String[] args) {
	    Lev lev = new Lev();
        Klietka<Lev> klietkaNaLeva = new Klietka<Lev>();
        klietkaNaLeva.vlozZviera(lev);
        klietkaNaLeva.vypis();
        System.out.println(klietkaNaLeva.getTextNaCedulke());

        Mys mys = new Mys();
        Klietka<Mys> klietkaNaMys = new Klietka<Mys>();
        klietkaNaMys.vlozZviera(mys);
        klietkaNaMys.vypis();
        System.out.println(klietkaNaMys.getTextNaCedulke());

        for (Mys prvok : klietkaNaMys) {
            System.out.println(prvok);
        }

        // Klietka<String> klietkaNaRetazce = new Klietka<String>();
    }
}

package fri.wof.predmety;

import fri.wof.hernySvet.Hrac;
import fri.wof.hernySvet.StandardnaMiestnost;

public class PortalGun implements IPredmet {
    private static final String[] NAZVY_PORTALOV = {"modry", "oranzovy"};

    private int indexPortalu;
    private final StandardnaMiestnost[] portaly;

    public PortalGun() {
        this.indexPortalu = 0;
        this.portaly = new StandardnaMiestnost[2];
    }

    @Override
    public String getNazov() {
        return "portalgun";
    }

    @Override
    public void pouzi(Hrac hrac) {
        if (!(hrac.getAktualnaMiestnost() instanceof StandardnaMiestnost aktualnaMiestnost)) {
            System.out.println("Tu sa portal neda otvorit");
            return;
        }

        for (int i = 0; i < this.portaly.length; i++) {
            if (this.portaly[i] != null) {
                this.portaly[i].zrusVychod(NAZVY_PORTALOV[i]);
            }
        }

        this.portaly[this.indexPortalu] = aktualnaMiestnost;

        if (this.portaly[0] != null && this.portaly[1] != null) {
            this.portaly[0].nastavVychod(this.portaly[1], NAZVY_PORTALOV[0]);
            this.portaly[1].nastavVychod(this.portaly[0], NAZVY_PORTALOV[1]);
            System.out.printf("Otvoril si %s portal do inej miestnosti%n", NAZVY_PORTALOV[this.indexPortalu]);
        } else {
            System.out.printf("Otvoril si %s portal, ale este nema koniec%n", NAZVY_PORTALOV[this.indexPortalu]);
        }

        this.indexPortalu = 1 - this.indexPortalu;
    }
}

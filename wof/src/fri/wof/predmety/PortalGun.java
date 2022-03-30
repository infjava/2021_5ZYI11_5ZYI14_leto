package fri.wof.predmety;

import fri.wof.hernySvet.Hrac;
import fri.wof.hernySvet.StandardnaMiestnost;

public class PortalGun implements IPredmet {
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

        for (StandardnaMiestnost miestnost : this.portaly) {
            if (miestnost != null) {
                miestnost.zrusVychod("portal");
            }
        }

        this.portaly[this.indexPortalu] = aktualnaMiestnost;
        this.indexPortalu = 1 - this.indexPortalu;

        if (this.portaly[0] != null && this.portaly[1] != null) {
            this.portaly[0].nastavVychod(this.portaly[1], "portal");
            this.portaly[1].nastavVychod(this.portaly[0], "portal");
            System.out.println("Otvoril si portal do inej miestnosti");
        } else {
            System.out.println("Otvoril si portal, ale este nema koniec");
        }
    }
}

package fri.wof.predmety;

import fri.wof.hernySvet.Hrac;
import fri.wof.hernySvet.Vytah;

public class OvladacVytahu implements IPredmet {
    @Override
    public String getNazov() {
        return "ovladac";
    }

    @Override
    public void pouzi(Hrac hrac) {
        if (hrac.getAktualnaMiestnost() instanceof Vytah vytah) {
            vytah.posunVytah();
        }
    }
}

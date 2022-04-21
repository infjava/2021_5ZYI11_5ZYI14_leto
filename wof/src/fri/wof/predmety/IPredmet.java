package fri.wof.predmety;

import fri.wof.hernySvet.Hrac;

import java.io.Serializable;

public interface IPredmet extends Serializable {
    String getNazov();

    void pouzi(Hrac hrac);
}

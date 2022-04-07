package fri.wof.hernySvet;

import fri.wof.predmety.OvladacVytahu;

import java.util.ArrayList;

public class Vytah extends Miestnost {
    private final ArrayList<Miestnost> poschodia;
    private int aktualnePoschodie;

    public Vytah(String popis) {
        super(popis);
        this.poschodia = new ArrayList<Miestnost>();
        this.aktualnePoschodie = 0;
        this.vlozPredmet(new OvladacVytahu());
    }

    public void pridajPoschodie(Miestnost miestnost) {
        this.poschodia.add(miestnost);
    }

    @Override
    public void vypisPopisMiestnosti() {
        System.out.println("Teraz si vo vytahu");
        System.out.println(this.getPopis());
        System.out.printf("Aktualne si na %d. poschodi, mozes ist von%n", this.aktualnePoschodie);
    }

    @Override
    public Miestnost getMiestnostVSmere(String smer) throws NespravnyVychodException {
        if (smer.equals("von")) {
            return this.poschodia.get(this.aktualnePoschodie);
        }
        throw new NespravnyVychodException();
    }

    public void posunVytah() {
        this.aktualnePoschodie++;
        if (this.aktualnePoschodie >= this.poschodia.size()) {
            this.aktualnePoschodie = 0;
        }
        this.vypisPopisMiestnosti();
    }
}

package fri.wof.prikazy;

import fri.wof.hernySvet.Hrac;
import fri.wof.hernySvet.NespravnyVychodException;
import fri.wof.hernySvet.VychodNepristupnyException;

/**
 * Trieda NazvyPrikazov udrzuje zoznam nazvov platnych prikazov hry. 
 * Za ulohu ma rozpoznavat platne prikazy.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

public class VykonavacPrikazov {
    // konstantne pole nazvov prikazov
    private static final String[] PLATNE_PRIKAZY = {
        "chod", "ukonci", "pomoc", "prehladaj", "zdvihni", "poloz", "pouzi",
        "porozpravaj"
    };

    /**
     * Kontroluje, ci nazov v parametri je platny prikaz.
     *  
     * @return true ak je parameter platny prikaz,
     * false inak.
     */
    public boolean jePrikaz(String nazov) {
        for (int i = 0; i < VykonavacPrikazov.PLATNE_PRIKAZY.length; i++) {
            if (VykonavacPrikazov.PLATNE_PRIKAZY[i].equals(nazov)) {
                return true;
            }
        }
        // ak algoritmus dosiahne tento bod, parameter nie je platny prikaz
        return false;
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param prikaz prikaz, ktory ma byt vykonany.
     * @param hra
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    public boolean vykonajPrikaz(Prikaz prikaz, Hrac hrac) {
        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String nazovPrikazu = prikaz.getNazov();

        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                return false;
            case "chod":
                this.chodDoMiestnosti(prikaz, hrac);
                return false;
            case "ukonci":
                return this.ukonciHru(prikaz);
            case "prehladaj":
                this.prehladajAktualnuMiestnost(hrac);
                return false;
            case "zdvihni":
                this.zdvihniPredmet(prikaz, hrac);
                return false;
            case "poloz":
                this.polozPredmet(prikaz, hrac);
                return false;
            case "pouzi":
                this.pouziPredmet(prikaz, hrac);
                return false;
            case "porozpravaj":
                this.porozpravajSNpc(prikaz, hrac);
                return false;
            default:
                return false;
        }
    }

    private void porozpravajSNpc(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("S kym sa to chces porozpravat?");
            return;
        }

        String menoNpc = prikaz.getParameter();

        hrac.porozpravajSaSNpc(menoNpc);
    }

    private void pouziPredmet(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("Aky predmet chces pouzit?");
            return;
        }

        String nazovPredmetu = prikaz.getParameter();

        hrac.pouziPredmet(nazovPredmetu);
    }

    private void polozPredmet(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("Aky predmet chces polozit?");
            return;
        }

        String nazovPredmetu = prikaz.getParameter();

        hrac.polozPredmet(nazovPredmetu);
    }

    private void zdvihniPredmet(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("Aky predmet chces zdvihnut?");
            return;
        }

        String nazovPredmetu = prikaz.getParameter();
        hrac.zdvihniPredmet(nazovPredmetu);
    }

    private void prehladajAktualnuMiestnost(Hrac hrac) {
        hrac.getAktualnaMiestnost().vypisZoznamPredmetov();
    }

    /**
     * Ukonci hru.
     * Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * fri.wof.prikazy.Prikaz ukoncenia nema parameter.
     *
     * @return true, ak prikaz konci hru, inak false.
     * @param prikaz
     */
    private boolean ukonciHru(Prikaz prikaz) {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     * @param prikaz
     * @param hra
     */
    private void chodDoMiestnosti(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        try {
            hrac.posunSa(smer);
        } catch (NespravnyVychodException e) {
            System.out.println("Tam nie je vychod!");
        } catch (VychodNepristupnyException e) {
            System.out.println("Nemozes vojst");
        }
    }

    /**
     * Vypise text pomocnika do terminaloveho okna.
     * Text obsahuje zoznam moznych prikazov.
     */
    private void vypisNapovedu() {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }
}

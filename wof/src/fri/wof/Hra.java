package fri.wof;

import fri.wof.hernySvet.HernySvet;
import fri.wof.hernySvet.Hrac;
import fri.wof.prikazy.Parser;
import fri.wof.prikazy.Prikaz;
import fri.wof.prikazy.VykonavacPrikazov;

import java.io.*;

/**
 * Trieda fri.wof.Hra je hlavna trieda aplikacie "World of FRI".
 * "World of FRI" je velmi jednoducha textova hra - adventura. 
 * fri.wof.hernySvet.Hrac sa moze prechadzat po niektorych priestoroch - miestnostiach fakulty.
 * To je v tejto verzii vsetko. Hru treba skutocne zancne rozsirit,
 * aby bola zaujimava.
 * 
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy fri.wof.Hra (hra)
 * a poslite jej spravu hraj.
 * 
 * fri.wof.Hra vytvori a inicializuje vsetky potebne objekty:
 * vytvori vsetky miestnosti, vytvori parser a zacne hru. fri.wof.Hra tiez vyhodnocuje
 * a vykonava prikazy, ktore vrati parser.
 * 
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
*/
 
public class Hra  {
    private static final int SAVE_MAGIC_NUMBER = 546456854;
    private static final int SAVE_VERSION = 1;

    private final Parser parser;
    private final Hrac hrac;
    @SuppressWarnings("FieldCanBeLocal")
    private final HernySvet hernySvet;
    private final VykonavacPrikazov vykonavacPrikazov;

    /**
     * Vytvori a inicializuje hru.
     */
    public Hra() {
        this.hernySvet = new HernySvet();
        this.hrac = new Hrac(this.hernySvet.getStartovaciaMiestnost());
        this.vykonavacPrikazov = new VykonavacPrikazov();
        this.parser = new Parser(this.vykonavacPrikazov);
    }

    /**
     *  Hlavna metoda hry.
     *  Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {            
        this.vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.
                
        boolean jeKoniec;
        
        do {
            Prikaz prikaz = this.parser.nacitajPrikaz();
            jeKoniec = this.vykonavacPrikazov.vykonajPrikaz(prikaz, this.hrac, this);
        } while (!jeKoniec);
        
        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        this.hrac.getAktualnaMiestnost().vypisPopisMiestnosti();
    }

    public void nacitajPoziciu(String nazovPozicie) {
        File suborPozicie = new File(nazovPozicie + ".wofsave");
        try (DataInputStream streamPozicie = new DataInputStream(new FileInputStream(suborPozicie))) {
            if (streamPozicie.readInt() != Hra.SAVE_MAGIC_NUMBER) {
                System.out.println("Toto je chybny save");
                return;
            }
            int verzia = streamPozicie.readInt();
            if (verzia > Hra.SAVE_VERSION) {
                System.out.println("Toto je save pre novsiu verziu WOF. Ak chces pokracovat, musis zacvakat.");
                return;
            }
            this.hrac.nacitajPoziciu(streamPozicie, verzia, this.hernySvet);
            this.hrac.getAktualnaMiestnost().vypisPopisMiestnosti();
        } catch (IOException e) {
            System.out.println("Sorry, ale tento save sa nepodaril. Prajem stastne hranie.");
            e.printStackTrace();
        }
    }

    public void ulozPoziciu(String nazovPozicie) {
        File suborPozicie = new File(nazovPozicie + ".wofsave");
        try (DataOutputStream streamPozicie = new DataOutputStream(new FileOutputStream(suborPozicie))) {
            streamPozicie.writeInt(Hra.SAVE_MAGIC_NUMBER);
            streamPozicie.writeInt(Hra.SAVE_VERSION);
            this.hrac.ulozPoziciu(streamPozicie);
        } catch (IOException e) {
            System.out.println("Sorry, ale tento save sa nepodaril. Prajem stastne hranie.");
            e.printStackTrace();
        }
    }
}

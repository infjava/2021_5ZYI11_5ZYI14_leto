package fri.wof;/*
 inventar
 - predmety
 - priklady:
   - kluce na dvere
   - navleky
   - isic na dvere
   - bagety (doplnenie hp)
 miestnosti minaju hp
 charakteristiky postavy
 - body (level up = rocnik)
 puzzle
 kombinovanie predmetov
   - crafting
 mapa sveta
 npc
 - rozpravat
   - davaju napovedy
 - questy davaju
 - predavaju predmety
 - priklady:
   - bufetarka predava bagety
   - vratnicka dava napovedy
 questy
 - sprav skusku
 - alt: uplatky
*/
/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 *
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Main {

    /**
     * @param args parametre programu
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.hraj();
    }
}

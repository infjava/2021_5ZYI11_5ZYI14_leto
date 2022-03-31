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
 > porozpravaj vratnicka
 Dobry den. Co si prajete? <== A
 1) Dobry den, jednu horalku
 2) Dobry den, aky je cas?
 3) Dobry den, kolko je na skole miestnosti?
 Vyber: 1
 To musite ist za bufetarkou <== B

 Dobry den. Co si prajete? <== A
 1) Dobry den, jednu horalku
 2) Dobry den, aky je cas?
 3) Dobry den, kolko je na skole miestnosti?
 Vyber: 2
 CEST, alebo UTC? <== C
 1) CEST
 2) UTC
 Vyber: 1
 12:59 <== D

 Dobry den. Co si prajete? <== A
 1) Dobry den, jednu horalku
 2) Dobry den, aky je cas?
 3) Dobry den, kolko je na skole miestnosti?
 Vyber: 2
 CEST, alebo UTC? <== C
 1) CEST
 2) UTC
 Vyber: 2
 10:59 <== E

 Dobry den. Co si prajete? <== A
 1) Dobry den, jednu horalku
 2) Dobry den, aky je cas?
 3) Dobry den, kolko je na skole miestnosti?
 Vyber: 3
 12, vratane vytahu. <== F

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

package fri.zoo;

import java.util.Iterator;

public class PrvocislaIterator implements Iterator<Integer> {
    private final int max;
    private int aktualnePrvocislo;

    public PrvocislaIterator(int max) {
        this.max = max;
        this.aktualnePrvocislo = 2;
    }

    @Override
    public boolean hasNext() {
        return this.aktualnePrvocislo < this.max;
    }

    @Override
    public Integer next() {
        while (!this.jePrvocislo())
            this.aktualnePrvocislo++;
        this.aktualnePrvocislo++;
        return this.aktualnePrvocislo - 1;
    }

    private boolean jePrvocislo() {
        for (int i = 2; i < this.aktualnePrvocislo; i++) {
            if (this.aktualnePrvocislo % i == 0) {
                return false;
            }
        }
        return true;
    }
}

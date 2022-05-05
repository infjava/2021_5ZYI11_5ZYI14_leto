package fri.zoo;

import java.util.Iterator;

public class Prvocisla implements Iterable<Integer> {
    private final int max;

    public Prvocisla(int max) {
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrvocislaIterator(this.max);
    }
}

package fri.zoo;

import java.util.Iterator;

public class KlietkaIterator<E> implements Iterator<E> {
    private final E zviera;
    private boolean uzSomVratil;

    public KlietkaIterator(E zviera) {
        this.uzSomVratil = zviera == null;
        this.zviera = zviera;
    }

    @Override
    public boolean hasNext() {
        return !this.uzSomVratil;
    }

    @Override
    public E next() {
        this.uzSomVratil = true;
        return this.zviera;
    }
}

package vzdornov.algo;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.RandomAccess;

public interface IContinuousCollection<E> extends RandomAccess/*, Iterable<E> */ {
    int size();
    int copacity();

    boolean isEmpty();

    // Iterator<E> iterator();
    // ListIterator<E> listIterator();

    void add(E element);
    E remove(int index);

    E get(int index);
    E get(int x,int y);
    void set(int index,E element);
    void set(int x,int y,E element);
}

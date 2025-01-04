package vzdornov.algo;

public interface IContinCollection<T> {

    void add(T item);

    T get(int index);

    int size();

    void add(T item, int index);

    T remove(int index);
}

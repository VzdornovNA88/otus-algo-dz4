package vzdornov.algo;

import java.lang.reflect.Array;

public final class MyArray<T> implements IContinuousCollection<T> {

    private T[] data;
    private int length;
    private int factor;
    private int columns;

    private void resize(Class<?> c) {
        @SuppressWarnings("unchecked")
        T[] dataNew = (T[]) Array.newInstance(c, length + length*factor + columns);
        System.arraycopy(data, 0, dataNew, 0, length);
        data = dataNew;
    }

    @SuppressWarnings("unchecked")
    public MyArray(Class<?> c, int s,int f0,int clms) {
        factor = f0;
        columns = clms;
        data = (T[]) Array.newInstance(c, s);
    }

    public MyArray(Class<?> c, int rws,int clms) {
        this(c,rws*clms,0,clms);
    }

    public MyArray(Class<?> c, int s) {
        this(c,s,0,1);
    }

    @Override
    public int size() {
        return length;
    }

    public int copacity() {
        return data.length;
    }

    @Override
    public void add(T item) {
        if( length > data.length - 1 ) {
            resize(item.getClass());
        }
        data[length] = item;
        length++;
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    public void set(int index, T element) {
        data[index] = element;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T remove(int index) {
        T value = data[index];
        length--;
        if (length > index) {
            System.arraycopy(data, index + 1, data, index, length - index);
        }
        data[length] = null;
        return value;
    }

    @Override
    public T get(int x, int y) {
        return get(x*columns+y);
    }

    @Override
    public void set(int x, int y,T element) {
        set(x*columns+y,element);
    }
}

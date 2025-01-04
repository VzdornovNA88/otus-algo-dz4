package vzdornov.algo;
import java.lang.reflect.Array;

public class FactorArray<T> implements IContinCollection<T> {

    private T[] array;
    private int size;
    private double factor;
    private Class<T[]> type;

    public FactorArray(Class<T[]> t, int len, double fact) {
        size = 0;
        type = t;
        array = type.cast(Array.newInstance(type.getComponentType(), len));
        factor = fact;
    }

    @Override
    public void add(T item) {
        if (size == array.length) {
            resize();
        }
        array[size] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item, int index) {
        if (size == array.length) {
            resize();
        }
        shiftR(index);
        array[index] = item;
        size++;
    }

    @Override
    public T remove(int index) {
        T item = array[index];
        if (index != size - 1)
            shiftL(index);
        array[size - 1] = null;
        size--;
        return item;
    }

    private void resize() {
        var newArray = type.cast(Array.newInstance(type.getComponentType(), size + (int)(size * factor + 0.5)));
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }

    private void shiftR(int index) {
        System.arraycopy(array, index, array, index + 1, size - index);
    }

    private void shiftL(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
    }
}

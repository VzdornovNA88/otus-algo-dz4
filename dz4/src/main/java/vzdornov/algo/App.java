package vzdornov.algo;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        IContinCollection<String> singleArray = new SingleArray<>();
        IContinCollection<String> vectorArray = new VectorArray<>();
        IContinCollection<String> factorArray = new FactorArray<>(String[].class,1,100.0/100);
        IContinCollection<String> matrixArray = new MatrixArray<>();

        addValues(singleArray, 100000);
        getValues(singleArray, 100000);
        removeValues(singleArray, 100000);

        addValues(vectorArray, 100000);
        getValues(vectorArray, 100000);
        removeValues(vectorArray, 100000);

        addValues(matrixArray, 100000);
        getValues(matrixArray, 100000);
        removeValues(matrixArray, 100000);

        addValues(factorArray, 100000);
        getValues(factorArray, 100000);
        removeValues(factorArray, 100000);

        testPriorityQueue();
    }

    private static void addValues(IContinCollection<String> array, int count) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int bound = 0;
            if (array.size() > 1) {
                bound = random.nextInt(array.size() - 1);
            }
            array.add(" " + i, bound);
        }
        System.out.println("add " + array + " " + count + ": " + (System.currentTimeMillis() - start) + " ms");
    }

    private static void getValues(IContinCollection<String> array, int count) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int bound = 0;
            if (array.size() > 1) {
                bound = random.nextInt(array.size() - 1);
            }
            array.get(bound);
        }
        System.out.println("get " + array + " " + count + ": " + (System.currentTimeMillis() - start) + " ms");
    }

    private static void removeValues(IContinCollection<String> array, int count) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int bound = 0;
            if (array.size() > 1) {
                bound = random.nextInt(array.size() - 1);
            }
            array.remove(bound);
        }
        System.out.println("remove " + array + " " + count + ": " + (System.currentTimeMillis() - start) + " ms");
    }


    private static void addValueByIndex(IContinCollection<String> array, int index) {
        array.add(" -index- ", index);
        System.out.println(array + " index " + index);
    }

    private static void removeValue(IContinCollection<String> array, int index) {
        String s = array.remove(index);
        System.out.println(array + " deleted value " + s + " index " + index);
    }

    private static void testPriorityQueue() {
        PriorityQueue<String> pQueue = new PriorityQueue<>();
        pQueue.enqueue(4, "First");
        pQueue.enqueue(1, "Second");
        pQueue.enqueue(2, "Thirth");
        System.out.println(pQueue.dequeue());
        System.out.println(pQueue.dequeue());
        System.out.println(pQueue.dequeue());
        pQueue.dequeue();
    }
}

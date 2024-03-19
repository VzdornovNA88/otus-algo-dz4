package vzdornov.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
        IContinuousCollection<Integer> arr = new MyArray<>(Integer.class,8,4);

        System.out.println("---------------- copacity() + size() + isEmpty()----------------");

        System.out.println(arr.copacity());
        System.out.println(arr.size());
        System.out.println(arr.isEmpty());

        System.out.println("---------------- add(i) + get(i,j)----------------");

        for(int i = 0; i < 64; i++) {
            arr.add(i);
        }

        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.println(arr.get(i,j));
            }
        }

        System.out.println("---------------- remove(i) + get(i)----------------");

        for(int i = 0; i < 64; i++) {
            System.out.println(arr.remove(i));
            System.out.println(arr.get(i));
        }

        System.out.println("---------------- set(i,val=i) + get(i)----------------");

        for(int i = 0; i < arr.copacity(); i++) {
            arr.set(i,i);
        }

        for(int i = 0; i < arr.copacity(); i++) {
            System.out.println(arr.get(i));
        }

        System.out.println("---------------- set(i,j,val=i*j) + get(i)----------------");

        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 4; j++) {
                arr.set(i,j,i*j);
            }
        }

        for(int i = 0; i < arr.copacity(); i++) {
            System.out.println(arr.get(i));
        }
    }
}

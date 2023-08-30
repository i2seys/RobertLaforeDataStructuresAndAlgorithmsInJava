import org.example.nontrivialSort.RadixSort;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RadixSortTest {

    @Test
    public void test1(){
        List<RadixSort> l = new LinkedList<>();
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            l.add(new RadixSort(r.nextInt(0, 1000)));
        }

        for (RadixSort item : l) {
            int[] toSort = item.getArr().clone();

            Arrays.sort(toSort);
            item.radixSortLinkedList();
            assertArrayEquals(item.getArr(), toSort);
        }
    }

    @Test
    public void test2(){
        List<RadixSort> l = new LinkedList<>();
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            l.add(new RadixSort(r.nextInt(0, 1000), 2, 0));
        }

        for (RadixSort item : l) {
            int[] toSort = item.getArr().clone();

            Arrays.sort(toSort);
            item.radixSortLinkedList();
            assertArrayEquals(item.getArr(), toSort);
        }
    }

    @Test
    public void test3(){
        List<RadixSort> l = new LinkedList<>();
        Random r = new Random();
        for(int i = 0; i < 100; i++){
            l.add(new RadixSort(r.nextInt(0, 1000), 1, 1));
        }

        for (RadixSort item : l) {
            int[] toSort = item.getArr().clone();

            Arrays.sort(toSort);
            item.radixSortLinkedList();
            assertArrayEquals(item.getArr(), toSort);
        }
    }
}

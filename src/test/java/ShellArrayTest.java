import org.example.nontrivialSort.ShellArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShellArrayTest {
    @Test
    public void test1() {
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
        ShellArray a = new ShellArray(test);
        a.shellSort();
        Arrays.sort(test);
        assertArrayEquals(a.getArr(), test);
    }
    @Test
    public void test2() {
        int[] test = new int[]{1};
        ShellArray a = new ShellArray(test);
        a.shellSort();
        Arrays.sort(test);
        assertArrayEquals(a.getArr(), test);
    }

    @Test
    public void test3() {
        int[] test = new int[]{1, 2};
        ShellArray a = new ShellArray(test);
        a.shellSort();
        Arrays.sort(test);
        assertArrayEquals(a.getArr(), test);
    }
    @Test
    public void test4() {
        int[] test = new int[]{7,6,5,4,3,2,1};
        ShellArray a = new ShellArray(test);
        a.shellSort();
        Arrays.sort(test);
        assertArrayEquals(a.getArr(), test);
    }
    @Test
    public void test5() {
        int[] test = new int[]{2,1};
        ShellArray a = new ShellArray(test);
        a.shellSort();
        Arrays.sort(test);
        assertArrayEquals(a.getArr(), test);
    }
    @Test
    public void test6() {
        int[] test = new int[]{};
        ShellArray a = new ShellArray(test);
        a.shellSort();
        Arrays.sort(test);
        assertArrayEquals(a.getArr(), test);
    }
    @Test
    public void test7() {
        int[] test = new int[100000];
        Random r = new Random();
        for(int i = 0; i < test.length; i++){
            test[i] = r.nextInt();
        }
        ShellArray a = new ShellArray(test);
        a.shellSort();
        Arrays.sort(test);
        assertArrayEquals(a.getArr(), test);
    }
}

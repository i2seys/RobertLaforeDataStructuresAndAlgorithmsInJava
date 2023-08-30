package org.example.nontrivialSort;

import java.util.*;

public class RadixSort {
    private final int[] arr;

    /**
     * Заполняет массив случайными числами
     * */
    public RadixSort(int capacity) {
        Random r = new Random();
        arr = new int[capacity];
        for(int i = 0; i < capacity; i++){
            arr[i] = r.nextInt(0, 1000);
        }
    }
    public RadixSort(int[] arr){
        this.arr = arr.clone();
    }
    public RadixSort(int capacity, int upper, int lower) {
        if(lower < 0)  throw new RuntimeException();

        Random r = new Random();
        arr = new int[capacity];
        for(int i = 0; i < capacity; i++){
            arr[i] = r.nextInt(lower, upper+1);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public void radixSortLinkedList(){
        if(arr.length == 0) return;

        long max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        LinkedList<Integer> zero = new LinkedList<>();
        LinkedList<Integer> one = new LinkedList<>();
        for (int j : arr) {
            if ((j & 1) == 1)  one.add(j);
            else zero.add(j);
        }
        long i = 2;
        while(i <= max){
            LinkedList<Integer> newOne = new LinkedList<>();
            LinkedList<Integer> newZero = new LinkedList<>();
            for(Integer num: zero){
                if((num & i) >= 1)  newOne.add(num);
                else newZero.add(num);
            }
            for(Integer num: one){
                if((num & i) >= 1) newOne.add(num);
                else newZero.add(num);
            }
            one = newOne;
            zero = newZero;
            i *= 2;
        }
        int j = 0;
        for(Integer num: zero) arr[j++] = num;
        for(Integer num: one)  arr[j++] = num;
    }

    public int[] getArr() {
        return arr;
    }
}

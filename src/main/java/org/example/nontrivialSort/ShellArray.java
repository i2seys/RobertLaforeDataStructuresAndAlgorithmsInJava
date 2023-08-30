package org.example.nontrivialSort;

import java.util.Arrays;
import java.util.Random;

public class ShellArray {
    //просто массив, без расширения.
    private int[] arr;

    /**
     * Заполняет массив случайными числами
     * */
    public ShellArray(int capacity) {
        Random r = new Random();
        arr = new int[capacity];
        for(int i = 0; i < capacity; i++){
            arr[i] = r.nextInt(-1000, 1000);
        }
    }
    public ShellArray(int[] arr){
        this.arr = arr.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
    public void insertionSort(){
        insertionSortN(1);
    }

    private void insertionSortN(int n){
        //сортировка вставками
        for(int i = n; i < arr.length; i++){
            //для i элемента ищем индекс вставки
            //2 1 5 4
            int j = i;
            int t = arr[j];
            while(j > n - 1 && arr[j-n]  > t){//j - n >= 0
                arr[j] = arr[j-n];
                j-=n;
            }
            arr[j] = t;
        }
    }
    public void shellSort(){
        //1)вычисление h
        int h = 1;
        while (h < arr.length / 3) h = h * 3 + 1;
        while(h > 0){
            insertionSortN(h);
            h = (h - 1) / 3;
        }
    }

    public int[] getArr() {
        return arr;
    }
}

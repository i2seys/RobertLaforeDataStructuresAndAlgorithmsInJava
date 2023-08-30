package org.example.nontrivialSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private int[] arr;

    /**
     * Заполняет массив случайными числами
     * */
    public QuickSort(int capacity) {
        Random r = new Random();
        arr = new int[capacity];
        for(int i = 0; i < capacity; i++){
            arr[i] = r.nextInt(0, 100);
        }
    }
    public QuickSort(int[] arr){
        this.arr = arr.clone();
    }

    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left-1;
        int rightPtr = right;
        while(true) {
            while( arr[++leftPtr] < pivot );

            while(rightPtr > 0 && arr[--rightPtr] > pivot);

            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }
    public void quickSort(){
        recQuickSort(0, arr.length - 1);
    }
    public void recQuickSort(int left, int right) {
        if (right - left <= 0){ // Если размер <= 1,
            return; // массив отсортирован.
        } // Для размера 2 и более

        long pivot = arr[right]; // Крайний правый элемент
        // Разбиение диапазона
        int partition = partitionIt(left, right, pivot);
        recQuickSort(left, partition-1); // Сортировка левой части
        recQuickSort(partition+1, right); // Сортировка правой части
    }
    private void swap(int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    public int[] getArr() {
        return arr;
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

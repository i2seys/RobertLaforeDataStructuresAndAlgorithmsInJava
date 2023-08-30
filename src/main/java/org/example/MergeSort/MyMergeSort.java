package org.example.MergeSort;

public class MyMergeSort {
    private static int[] temp;
    public static void mergeSort(int[] arr){
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int lower, int upper) {
        if(lower == upper){
            return;
        }
        int mid = upper + (lower - upper) / 2;
        mergeSort(arr, lower, mid-1);
        mergeSort(arr, mid, upper);
        merge(arr, lower, mid, upper);
    }

    private static void merge(int[] arr, int lower, int mid, int upper) {
        //1)в массив workSpace записываем сортировку двух массивов:  arr[lowPtr:highPtr-1] и arr[highPtr:upperBound] включительно
        //2)в массив arr, начиная с индекса lowPtr(изначального) записываем то, что отсортировали
        int j = 0;//индекс для temp int[]
        int initLower = lower;
        int startUpper = mid;
        int count = upper - lower + 1;
        int endLower = mid - 1;
        while(lower <= endLower && startUpper <= upper){
            if(arr[lower] < arr[startUpper]){
                temp[j++] = arr[lower++];
            }
            else{
                temp[j++] = arr[startUpper++];
            }
        }
        while(lower <= endLower) {
            temp[j++] = arr[lower++];
        }

        while(startUpper <= upper){
            temp[j++] = arr[startUpper++];
        }
        for(j = 0; j < count; j++){
            arr[j+initLower] = temp[j];
        }
    }
}

package org.example.arrayBased;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class MyArray {
    private long[] array;
    public MyArray(int size){
        array = new long[size];
        for(int i = 0; i < size; i++){
            array[i] = 0;
        }
    }
    public MyArray(long[] collection){
        array = collection;
    }
    public MyArray(int[] collection){
        array = new long[collection.length];
        for(int i = 0; i < collection.length; i++){
            array[i] = collection[i];
        }
    }
    public long[] getArray(){
        return array;
    }
    public int length(){
        return array.length;
    }
    //максимальный элемент
    //минимальный элемент
    //сортировка вставкой
    //стр 98
    public void set(int index, int value){
        array[index] = value;
    }
    /**
     * Добавление нового элемента в конец массива.
    **/
    public void add(long value){
        long[] tempArr = new long[array.length + 1];
        //копируем старый массив в новый временный
        int i;
        for(i = 0; i < array.length; i++){
            tempArr[i] = array[i];
        }
        tempArr[i+1] = value;
        array = tempArr;
    }
    /**
     * Добавление элемента в определённое место массива.
    **/
    public void add(int index, long value){
        long[] tempArr = new long[array.length + 1];
        int i;
        for(i = 0; i < index; i++){
            tempArr[i] = array[i];
        }
        tempArr[index] = value;
        for(i = index + 1; i < tempArr.length; i++){
            tempArr[i] = array[i-1];
        }
        array = tempArr;
    }
    /**
     * Возвращает индекс первого вхождения данного элемента, если его нет - возвращает -1.
     **/
    public int findElement(int value){
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }
    private void swap(int firstInd, int secondInd){
        long temp = array[firstInd];
        array[firstInd] = array[secondInd];
        array[secondInd] = temp;
    }
    public void bubbleSort(){
        for(int i = array.length; i > 0; i--){
            for(int j = 0; j < i - 1; j++){
                if(array[j] > array[j+1]){
                    swap(j, j+1);
                }
            }
        }
    }
    public void selectionSort(){
        //1)найти минимальный элемент
        //2)поменять местами минимальный и start
        //3)start++ (цикл начинается с start внешнй)
        for(int start = 0; start < array.length; start++){
            int indexOfMin = 0;
            long min = Integer.MAX_VALUE;
            for(int j = start; j < array.length; j++){
                 if(array[j] < min){
                     min = array[j];
                     indexOfMin = j;
                 }
            }
            swap(start, indexOfMin);
        }
    }
    public void insertionSort(){
        //1)берём промежуток n (n начинается с 1 и до (размера_массива-1))
        //2)берём индекс n и протаскиваем его влево до тех пор, пока элемент [j] > [j+1] (в самом начале j=n
        for(int len = 1; len < array.length; len++){
            int i = len;
            long value = array[i];
            while(i > 0 && value < array[i-1]){// Пока не найден меньший элемент
                array[i] = array[i-1];// Сдвинуть элемент вправо
                i--;// Перейти на одну позицию влево
            }
            array[i] = value;
        }
    }
    public void delete(){
        long[] tempArr = new long[array.length - 1];
        for(int i = 0; i < tempArr.length; i++){
            tempArr[i] = array[i];
        }
        array = tempArr;
    }
    public void delete(int index){
        long[] tempArr = new long[array.length - 1];
        for(int i = 0; i < index; i++){
            tempArr[i] = array[i];
        }
        for(int i = index + 1; i < array.length; i++){
            tempArr[i] = array[i-1];
        }
        array = tempArr;
    }
    public static MyArray randomArray(int length, int lowerBound, int upperBound){
        long[] resultArr = new long[length];
        Random r = new Random();
        for(int i = 0; i < length; i++){
            resultArr[i] = r.nextInt(lowerBound, upperBound+1);
        }
        return new MyArray(resultArr);
    }
    public static MyArray sortedArray(int length){
        MyArray arr = new MyArray(length);
        for(int i = 0; i < length; i++){
            arr.add(i,i);
        }
        return arr;
    }
    public long median(){
        insertionSort();
        return array[array.length / 2 - array.length % 2];
    }
    public MyArray noDups(){
        //требуется начальная сортировка
        long[] initialArr = array;
        Arrays.sort(array);
        long[] res = new long[array.length];
        res[0] = initialArr[0];
        int j = 0;//переменная для записи в новый массив
        for(int i = 1; i < initialArr.length; i++){
            if(res[j] != (array[i])){
                j++;
                res[j] = array[i];
            }
        }
        return new MyArray(Arrays.copyOf(res, j+1));
    }
    public void oddEvenSort(){
        for (int i = 0; i < array.length; i++) {
            // (i % 2) ? 0 : 1 возвращает 1, если i четное, 0, если i не четное
            //если i чётное, то j перебирает нечётные индексы
            //если i нечётное, то j перебирает чётные индексы
            for (int j = (i % 2 == 1) ? 0 : 1; j + 1 < array.length; j += 2) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }
}

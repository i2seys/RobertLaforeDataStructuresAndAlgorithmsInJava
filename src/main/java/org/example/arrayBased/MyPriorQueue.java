package org.example.arrayBased;


public class MyPriorQueue {
    private int[] array;
    private int items;
    private int maxSize;
    public MyPriorQueue(int capacity){
        array = new int[capacity];
        items = 0;
        maxSize = capacity;
    }
    public int size(){
        return items;
    }
    //remove peek insert
    public boolean isEmpty(){
        return items == 0;
    }
    public boolean isFull(){
        return items == maxSize;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue size = 0");
        }
        return array[items - 1];
    }
    //выглядит так: 80 60 10 -10 -50
    public int remove(){
        if(isEmpty()){
            throw new RuntimeException("Queue size = 0");
        }
        return array[--items];
    }
    public void insert(int value){
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        else if(isEmpty()){
            array[0] = value;
            items++;
        }
        else{
            int i = items - 1;
            while(i >= 0 && array[i] < value){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = value;
            items++;
        }
    }
    public void print(){
        for(int i = 0; i < items; i++){
            System.out.print(array[i]);
        }
    }
}

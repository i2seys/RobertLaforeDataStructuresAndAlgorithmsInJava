package org.example.arrayBased;

public class MyQueue {
    private int[] array;
    private int out;
    private int in;
    private int items;
    public MyQueue(int capacity){
        array = new int[capacity];
        out = 0;
        in = 0;
        items = 0;
    }
    public void insert(int value){
        if(isFull()){
            System.out.println("Order is full");
            return;
        }
        array[in++] = value;
        if(in == array.length){
            in = 0;
        }
        items++;
    }
    public int remove(){
        //убирает и читает
        if(isEmpty()){
            System.out.println("Order is empty");
            throw new RuntimeException();
        }
        int res = array[out--];
        items--;
        if(out == -1){
            out = array.length-1; //max:4 [9,5,2,8]
        }
        return res;
    }
    public int peek(){
        return array[out];
    }
    public boolean isEmpty(){
        return items==0;
    }
    public boolean isFull(){
        return items == array.length;
    }
    public int size(){
        return items;
    }
    public void print(){
        //надо начать с out и либо до array.size либо до in
        if(in < out){
            //значит, что список перевёрнут
            for(int i = out; i < items; i++){
                System.out.print(array[i] + " ");
            }
            for(int i = 0; i < in; i++){
                System.out.print(array[i] + " ");
            }
        }
        else if(in > out){
            //обычные условия
            for(int i = out; i < in; i++){
                System.out.print(array[i] + " ");
            }
        }
        else{//in == out, значит либо элементов нет, либо массив полон
            if(isEmpty()){
                System.out.println("Queue is empty");
            }
            else{
                //вывод с разделителем
                for(int i = in+1; i < items; i++){
                    System.out.print(array[i] + " ");
                }
                for(int i = 0; i < in+1; i++){
                    System.out.print(array[i] + " ");
                }
            }
        }
        System.out.println();
    }
}

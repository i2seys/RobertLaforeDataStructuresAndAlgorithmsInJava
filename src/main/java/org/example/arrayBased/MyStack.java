package org.example.arrayBased;

import java.util.Objects;
import java.util.function.Supplier;

public class MyStack {

    private char[] array;
    private int length;
    public MyStack(int capacity){
        array = new char[capacity];
        length = 0;
    }
    public MyStack(char[] array){
        this.array = array;
    }
    public int getLength() {
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    //извлечение и удаление элемента сверху
    public char pop(){
        return array[length--];
    }
    public void push(char value){
        array[++length] = value;
    }
    public char peek(){
        return array[length];
    }
}

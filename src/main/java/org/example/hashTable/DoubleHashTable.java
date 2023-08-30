package org.example.hashTable;

import org.example.hashTable.HashItem;
import org.example.hashTable.HashTable;

public class DoubleHashTable implements HashTable {
    private final HashItem noneItem;
    private final HashItem[] table;
    private int currentSize;
    private boolean isPrimary(int num){
        if(num <= 2) return true;

        if(num % 2 == 0) return false;

        for(int i = 3; i*i <=num; i+=2){
            if(num % i == 0) return false;
        }
        return true;
    }

    public DoubleHashTable(int capacity) {
        while(!isPrimary(capacity)){
            capacity++;
        }
        System.out.println("Table capacity: " + capacity);
        table = new HashItem[capacity];
        currentSize = 0;
        noneItem = new HashItem(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == table.length - 1;
    }
    @Override
    public int hashFunc(int key) {
        return key % table.length;
    }
    public int hashFuncStep(int key){
        int stepConst = 5;
        return stepConst - (key % stepConst);
    }
    @Override
    public Integer find(int key) {
        if(isEmpty()) return null;
        int ind = hashFunc(key);
        int step = hashFuncStep(key);
        for(int i = 0; i < table.length; i++){
            if(table[ind] == null) return null;
            if(table[ind].key == key) return table[ind].value;
            ind = hashFunc(ind + step);
        }
        return null;
    }

    @Override
    public boolean containsKey(int key) {
        return find(key) != null;
    }

    @Override
    public boolean insert(int key, int value) {
        if(isFull()) return false;
        if(containsKey(key)) return false;
        int ind = hashFunc(key);
        int step = hashFuncStep(key);
        for(int i = 0; i < table.length; i++){
            if(table[ind] == null || table[ind] == noneItem){
                table[ind] = new HashItem(key, value);
                currentSize++;
                return true;
            }
            ind = hashFunc(ind + step);
        }
        return false;
    }

    @Override
    public Integer delete(int key) {
        if(key == noneItem.key) return null;
        if(isEmpty()) return null;
        int ind = hashFunc(key);
        int step = hashFuncStep(key);
        for(int i = 0; i < table.length; i++){
            if(table[ind] == null) return null;
            if(table[ind].key == key){
                int val = table[ind].value;
                table[ind] = noneItem;
                currentSize--;
                return val;
            }
            ind = hashFunc(ind + step);
        }
        return null;
    }

    @Override
    public void print(){
        if(isEmpty()) {
            System.out.println("Is empty");
            return;
        }

        for (HashItem hashItem : table) {
            if (hashItem != null && hashItem != noneItem) {
                System.out.print("{" + hashItem.key + " " + hashItem.value + "} ");
            } else {
                System.out.print("*** ");
            }
        }
        System.out.println();
    }
}

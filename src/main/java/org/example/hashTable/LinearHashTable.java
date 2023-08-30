package org.example.hashTable;


import org.example.hashTable.HashItem;
import org.example.hashTable.HashTable;

public class LinearHashTable implements HashTable {
    private final HashItem noneItem;
    private final HashItem[] table;
    private int currentSize;
    public LinearHashTable(int capacity){
        table = new HashItem[capacity];
        currentSize = 0;
        noneItem = new HashItem(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == table.length;
    }
    public int hashFunc(int key){
        return key < 0 ? (-(key + 1) % table.length) : key % table.length;
    }
    public Integer find(int key){
        if(isEmpty()) return null;
        //добавить случай для full
        int ind = hashFunc(key);
        for(int i = 0; i < table.length; i++){
            if(table[ind] == null) {
                return null;
            }
            if(table[ind].key == key){
                return table[ind].value;
            }
            ind = hashFunc(ind + 1);
        }
        return null;
    }
    public boolean containsKey(int key){
        return find(key) != null;
    }
    public boolean insert(int key, int value){
        if(key == noneItem.key) return false;

        if(containsKey(key)) return false;
        int ind = hashFunc(key);
        if(isFull()) return false;
        while(table[ind] != null && table[ind] != noneItem){
            ind = hashFunc(ind + 1);
        }
        table[ind] = new HashItem(key, value);
        currentSize++;
        return true;
    }
    public Integer delete(int key){
        if(key == noneItem.key) return null;
        if(isEmpty()) return null;
        int ind = hashFunc(key);

        for(int i = 0; i < table.length; i++){
            if(table[ind].key == key){
                HashItem res = table[ind];
                table[ind] = noneItem;
                currentSize--;
                return res.value;
            }
            ind = hashFunc(ind + 1);
        }
        return null;
    }
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

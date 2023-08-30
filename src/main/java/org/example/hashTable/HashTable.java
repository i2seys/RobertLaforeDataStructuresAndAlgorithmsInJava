package org.example.hashTable;

public interface HashTable {
    boolean isEmpty();
    boolean isFull();
    int hashFunc(int key);
    Integer find(int key);
    boolean containsKey(int key);
    boolean insert(int key, int value);
    Integer delete(int key);
    void print();

}

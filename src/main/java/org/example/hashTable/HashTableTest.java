package org.example.hashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HashTableTest {
    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //--------------------------------------------------------------
    private static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    //-------------------------------------------------------------
    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    public static void test(Class clazz) throws IOException {
        if(!clazz.equals(LinearHashTable.class) && !clazz.equals(DoubleHashTable.class)) return;
        Random r = new Random();
        int aKey, size, n, keysPerCell;
        // Ввод размеров
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
        HashTable theHashTable;
        if(clazz.equals(DoubleHashTable.class)){
            theHashTable = new DoubleHashTable(size);
        }
        else{
            theHashTable = new LinearHashTable(size);
        }

        for(int j=0; j<n; j++) // Вставка данных
        {
            aKey = (int)(java.lang.Math.random() *
                    keysPerCell * size);
            theHashTable.insert(aKey, r.nextInt(-100, 101));
        }
        while(true) // Взаимодействие с пользователем
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's' -> theHashTable.print();
                case 'i' -> {
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    theHashTable.insert(aKey, r.nextInt());
                }
                case 'd' -> {
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                }
                case 'f' -> {
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    Integer aDataValue = theHashTable.find(aKey);
                    if (aDataValue != null) {
                        System.out.println("Found " + aKey);
                    } else
                        System.out.println("Could not find " + aKey);
                }
                default -> System.out.print("Invalid entry\n");
            }
        }
    }
}

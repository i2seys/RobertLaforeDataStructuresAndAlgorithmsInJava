package org.example;

public class MyPermutationBook {
    private static char[] chars;
    private static int count;
    private static int size;
    public static void doAnagram(String s){
        chars = s.toCharArray();
        count = 0;
        size = s.length();
        doAnagram(size);
    }
    private static void doAnagram(int currSize){
        if(currSize == 1){
            return;
        }
        for(int i = 0; i < currSize; i++){
            doAnagram(currSize - 1);
            if(currSize == 2) display();
            offset(currSize);
        }
    }

    private static void offset(int currSize) {
        int pos = size - currSize;
        char ch = chars[pos];
        for(int j = pos; j < size-1; j++){
            chars[j] = chars[j+1];
        }
        chars[size-1] = ch;
    }

    private static  void display(){
        System.out.printf("Word %d: ", ++count);
        for(int j=0; j<size; j++)
            System.out.print(chars[j]);
        System.out.println();
    }
}

package org.example.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static List<String> combinations(int n, int k){
        return combinationsRec(n,k,1);
    }
    private static List<String> combinationsRec(int n, int k, int firstNum){
        if(n == 1){
            //значит надо выбрать из 1 чего-то k чего-то
            if(k == 1){
                return new ArrayList<>(Arrays.asList(String.valueOf(firstNum)));
            }
            else{
                return new ArrayList<>();
            }
        }
        if(k == 1){
            //значит надо выбрать из n объектов все варианты по 1 объекту
            List<String> res = new ArrayList<>();
            for(int i = firstNum; i < n+firstNum; i++){
                res.add(String.valueOf(i));
            }
            return res;
        }
        List<String> l1 = combinationsRec(n-1, k-1, firstNum + 1);
        for(int i = 0; i < l1.size(); i++){
            l1.set(i, firstNum + l1.get(i));
        }
        List<String> l2 = combinationsRec(n-1, k, firstNum + 1);
        l1.addAll(l2);
        return l1;
    }

    public static List<List<Integer>> combineIntArr(int n, int k) {
        return combinationsRecIntArr(n,k,1);
    }

    private static List<List<Integer>> combinationsRecIntArr(int n, int k, int firstNum){
        if(n == 1){
            //значит надо выбрать из 1 чего-то k чего-то
            if(k == 1){
                List<List<Integer>> temp = new ArrayList<>();
                temp.add(new ArrayList<>(Arrays.asList(firstNum)));
            }
            else{
                return new ArrayList<>();
            }
        }
        if(k == 1){
            //значит надо выбрать из n объектов все варианты по 1 объекту
            List<List<Integer>> res = new ArrayList<>(n);
            for(int i = firstNum; i < n+firstNum; i++){
                res.add(new ArrayList<>(Arrays.asList(i)));
            }
            return res;
        }
        List<List<Integer>> l1 = combinationsRecIntArr(n-1, k-1, firstNum + 1);
        for(int i = 0; i < l1.size(); i++){
            List<Integer> temp = l1.get(i);
            temp.add(0, firstNum);
        }
        List<List<Integer>> l2 = combinationsRecIntArr(n-1, k, firstNum + 1);
        l1.addAll(l2);
        return l1;
    }
}

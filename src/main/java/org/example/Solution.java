package org.example;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        StringBuilder res = new StringBuilder(n1 > n2 ? n1 + 1 : n2 + 1);
        int ost = 0;
        while(n2 != -1 && n1 != -1){
            int temp = (num1.charAt(n1) - '0') + (num2.charAt(n2) - '0') + ost;
            if(temp >= 10){
                ost = 1;
                temp = temp % 10;
            }
            else{
                ost = 0;
            }
            res.insert(0, Integer.toString(temp));
            n2--;
            n1--;
        }

        if(n2 == -1 && n1 != -1){
            //то надо остаток добавить к num1 и добавить в String
            if(ost != 0){
                while(n1 != -1){
                    int temp = (num1.charAt(n1) - '0') + ost;
                    if(temp >= 10){
                        ost = 1;
                        temp = temp % 10;
                        res.insert(0, Integer.toString(temp));
                        n1--;
                    }
                    else{
                        res.insert(0, temp);
                        res.insert(0, num1.substring(0, n1));
                        ost = 0;
                        break;
                    }
                }
                if(ost == 1) {
                    res.insert(0, ost);
                }
            }
            else{
                res.insert(0, num1.substring(0, n1+1));
            }

        }
        else if(n1 == -1 && n2 != -1){
            if(ost != 0){
                while(n2 != -1){
                    int temp = (num2.charAt(n2) - '0') + ost;
                    if(temp >= 10){
                        ost = 1;
                        temp = temp % 10;
                        res.insert(0, Integer.toString(temp));
                        n2--;
                    }
                    else{
                        res.insert(0, temp);
                        res.insert(0, num2.substring(0, n2));
                        ost = 0;
                        break;
                    }
                }
                if(ost == 1) {
                    res.insert(0, ost);
                }
            }
            else{
                res.insert(0, num2.substring(0, n2+1));
            }
        }
        return res.toString();
    }
}
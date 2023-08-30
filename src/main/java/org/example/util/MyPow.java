package org.example.util;

public class MyPow {
    public static double power(int x, int y){
        if (y != 1){
            double ans = power(x*x, y/2);
            if (y % 2 == 1){
                return ans * x;
            }
            else{
                return ans;
            }
        }
        else{
            return x;
        }
    }
}

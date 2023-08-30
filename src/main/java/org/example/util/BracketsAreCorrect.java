package org.example.util;

import org.example.arrayBased.MyStack;

public class BracketsAreCorrect {
    public  boolean bracketsAreCorrect(String s){
        MyStack stack = new MyStack(s.length());
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            char lastStackChar = stack.peek();
            if(isParenthesisOpposite(lastStackChar, currentChar)){
                stack.pop();
            }
            else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }
    private  boolean isParenthesisOpposite(char ch1, char ch2){
        if((ch1 == '{' && ch2 == '}') || (ch1 == '(' && ch2 == ')' ) || (ch1 == '[' && ch2 == ']')){
            return true;
        }
        else{
            return false;
        }
    }
}

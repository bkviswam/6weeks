package com.facebook;

import java.util.Stack;

public class ValidParenthesis {
    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='c') stack.push(')');
            else if(c=='{') stack.push('}');
            else if(c=='[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        String s = "{{{())}}";
        System.out.println("Is valid "+vp.isValid(s));
    }
}

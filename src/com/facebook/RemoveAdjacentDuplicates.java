package com.facebook;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s) {
        if(s.length()==1) return s;
        Deque<Character> stack = new ArrayDeque<>();
        stack.addFirst(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peekFirst() == s.charAt(i)){
                stack.removeFirst();
            }else{
                stack.addFirst(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        RemoveAdjacentDuplicates ra = new RemoveAdjacentDuplicates();
        String s = "abbaca";
        System.out.println("The String after duplicated removed :"+ra.removeDuplicates(s));
    }
}

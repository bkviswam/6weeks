package com.facebook;

/**
 *
 * 367. Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 */

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num <= 1) return  true;
        long start = 2; // Set the left boundary to 2, and
        long end = num/2;  // Set the right boundary to num / 2.
        while(start<=end){
            long mid = start + (end - start) / 2;
            if(mid * mid == num) return true;
            else if (mid * mid >  num){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        int num = 16;
        System.out.println("Is valid perfect square :"+vps.isPerfectSquare(num));
    }
}

package com.facebook;

import java.util.Arrays;

/**
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroesRight {
    public void moveZeroes(int[] num) {
        int i=0;
        for(int j=0; j<num.length; j++){
            if(num[j]!=0){
                num[i]=num[j];
                i++;
            }
        }
        while(i<num.length){
            num[i]=0;
            i++;
        }
    }
    public static void main(String[] args) {
        MoveZeroesRight mr = new MoveZeroesRight();
        int [] num = new int[] {0,1,0,3,12};
        mr.moveZeroes(num);
        System.out.println(Arrays.toString(num));
    }
}

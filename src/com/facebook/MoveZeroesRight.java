package com.facebook;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroesRight {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast]!=0){
                nums[slow++] = nums[fast++];
            }else{
                fast++;
            }
        }
        while(slow < nums.length){
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroesRight mr = new MoveZeroesRight();
        int[] num = new int[]{0, 1, 0, 3, 12};
        mr.moveZeroes(num);
        System.out.println(Arrays.toString(num));
    }
}

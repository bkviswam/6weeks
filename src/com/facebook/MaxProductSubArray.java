package com.facebook;

/**
 * 152. Maximum Product Subarray
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 */

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int maxProduct  = Integer.MIN_VALUE;
        int product1 = 1;
        int product2 = 1;
        for(int i=0; i<nums.length; i++){
            //forward product
            product1 *= nums[i];
            maxProduct = Math.max(maxProduct, product1);
            product1 = product1==0 ? 1 : product1;
            //reverse product
            product2 *= nums[nums.length-1-i];
            maxProduct = Math.max(maxProduct, product2);
            product2 = product2 == 0 ? 1 : product2;
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        MaxProductSubArray mps = new MaxProductSubArray();
        int [] nums = new int[] {2,3,-2,4};
        System.out.println("The max product "+mps.maxProduct(nums));
    }
}

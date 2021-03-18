package com.facebook;

/**
 * 42. Trapping Rain Water  // Hard
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int water = 0;
        int minHeight = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (minHeight < height[i]) minHeight = height[i];
                water = water + (minHeight - height[i]);
                i++;
            } else {
                if (minHeight < height[j]) minHeight = height[j];
                water = water + (minHeight - height[j]);
                j--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater tr = new TrappingRainWater();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(tr.trap(height));
    }
}

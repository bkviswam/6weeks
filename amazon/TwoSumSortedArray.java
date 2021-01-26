import java.util.Arrays;

/**

167. Two Sum II - Input array is sorted -- Easy  // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/


Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
 

Constraints:

2 <= nums.length <= 3 * 104
-1000 <= nums[i] <= 1000
nums is sorted in increasing order.
-1000 <= target <= 1000

**/ 

public class TwoSumSortedArray{

	 public int[] twoSum(int[] nums, int target) {
	 	int i = 0;
	 	int j = nums.length-1;

	 	while(i<j){
	 		int sum = nums[i]+nums[j];
	 		if(sum==target){
	 			return new int[]{i+1, j+1}; // 1 indexed
	 		}else if(sum<target){
	 			i++;
	 		}else if(sum>target){
	 			j--;
	 		}
	 	}
	 	return new int[]{};
	 }

	public static void main(String[] args) {
		TwoSumSortedArray ts = new TwoSumSortedArray();
		int nums[] = new int[]{2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(ts.twoSum(nums, target)));
	}
}
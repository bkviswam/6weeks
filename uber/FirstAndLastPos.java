
import java.util.Arrays;
/**

34. Find First and Last Position of Element in Sorted Array -- Medium

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?


Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109


**/

public class FirstAndLastPos{

	public int search(int [] nums, int target, boolean first){
		int ans = -1;
		int left = 0;
		int right = nums.length - 1;

		while(left <= right){
			int mid = left + (right - left)/2;
			if(target == nums[mid]){
				ans = mid;
				if(first){
					right = mid - 1;
				}else{
					left = mid + 1;
				}

			}else if(target > nums[mid]){
				left = mid + 1;
			}else{
				right = mid  - 1; 
			}
		}
		return ans;
	}

	public int[] searchRangeII(int [] nums, int target){
		return new int[] {search(nums, target, true),search(nums, target, false)};
	}

	//Brute Force O(n) Solution
	public int[] searchRange(int[] nums, int target){
		int [] defaultRes = new int[]{-1,-1};
		for(int i=0; i<nums.length; i++){
			if(nums[i]==target){
				defaultRes[0]=i;
				break;
			}
		}

		if(defaultRes[0]==-1){
			return defaultRes;
		}

		for(int j=nums.length-1; j>=0; j--){
			if(nums[j]==target){
				defaultRes[1]=j;
				break;
			}
		}

		return defaultRes;

	}
	public static void main(String[] args) {
		FirstAndLastPos flp = new FirstAndLastPos();
		int [] nums = new int[]{5,7,7,8,8,10};
		int k = 7;
		System.out.println(Arrays.toString(flp.searchRange(nums, k)));
		System.out.println(Arrays.toString(flp.searchRangeII(nums, k)));
	}
}
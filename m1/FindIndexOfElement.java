
/**

LC 33. Search in Rotated Sorted Array  // Medium


Given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You should search for target in nums and if you found return its index, otherwise return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4


**/


public class FindIndexOfElement {
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]>=nums[start]){
				if(target  >= nums [start] && target < nums [mid]){
					end = mid - 1;
				}else {
					start  = mid + 1;
				}
			}else{
				if(target  > nums [mid] && target <= nums [end]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
		}
        return -1;
    }
	public static void main(String[] args) {
		FindIndexOfElement fe = new FindIndexOfElement();
		//int [] nums = new int [] {4,5,6,7,0,1,2};
		//int target = 0 ;
		int [] nums = new int [] {3,1};
		int target = 1 ;
		System.out.println(fe.search(nums,target));
	}
}
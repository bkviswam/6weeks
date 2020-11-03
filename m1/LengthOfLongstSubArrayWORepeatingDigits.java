import java.util.Set;
import java.util.HashSet;


/**

Daily Coding Problem: Problem #489

Given an array of elements, return the length of the longest subarray where all its elements are distinct.

For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].

**/

public class LengthOfLongstSubArrayWORepeatingDigits {
	public int lengthOfLongestArray(int [] nums){
		int n = nums.length;
		int i=0, j=0;
		int ans =0;
		Set<Integer> set = new HashSet<>();
		while(i < n && j < n){
			if(!set.contains(nums[j])){
				set.add(nums[j++]);
				ans = Math.max(ans, j-i);
			}else{
				set.remove(nums[i++]);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LengthOfLongstSubArrayWORepeatingDigits ll = new LengthOfLongstSubArrayWORepeatingDigits();
		int [] nums = new int[]{5, 1, 3, 5, 2, 3, 4, 1};
		System.out.println(ll.lengthOfLongestArray(nums));
	}
}
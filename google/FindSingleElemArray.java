/**

Given an array that contains n numbers out of which except one value all the other values are repeated twice. Find the number in the array that occurs only once.

**/

public class FindSingleElemArray{

	public int findSingle(int[] nums){
		int res = 0;
		for(int i = 0; i< nums.length; i++){
			res = res ^ nums[i];
		}
		return res;
	}


	public static void main(String[] args) {
		FindSingleElemArray fi = new FindSingleElemArray();
		int nums [] = new int [] {3,5,7,5,3,1,2,4,4,2,1};
		System.out.println(fi.findSingle(nums));
	}
}
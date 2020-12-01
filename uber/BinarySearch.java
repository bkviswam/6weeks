import java.util.Arrays;

public class BinarySearch {

	public boolean search(int[] nums, int target){
		int low = 0;
		int high = nums.length;
		Arrays.sort(nums);
		//System.out.println(Arrays.toString(nums));
		while(low <= high){
			int mid = low + (high - low)/2;
			//System.out.println(mid);
			if(nums[mid] == target){
				return true;
			}else if (target > nums[mid]){
				low = mid+1;
			}else{
				high = mid-1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int nums [] = new int[]{4,6,7,8,9,11,0,5,2,10};
		int n = 10;
		if(bs.search(nums, n)){
			System.out.println("The number is found ");
		}else{
			System.out.println("The number is NOT found ");
		}
	}
}
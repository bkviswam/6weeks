import java.util.Arrays;

public class RotateArrayByKElements{
	private int[] rotateArrayRight(int [] nums, int k){
		int n = nums.length;
		while(k > 0){
			for(int i=0; i<n-1; i++){
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			}
			k--;
		}
		return nums;
	}

	private int[] rotateArrayLeft(int [] nums, int k){
		int n = nums.length;
		while(k > 0){
			for(int i=n-1; i>0; i--){
				int temp = nums[i];
				nums[i] = nums[i-1];
				nums[i-1] = temp;
			}
			k--;
		}
		return nums;
	}

	public static void main(String[] args) {
		RotateArrayByKElements ra = new RotateArrayByKElements();
		int nums[] = new int[]{1,2,3,4,5,6};
		int k = 5;
		System.out.println("Original Array "+Arrays.toString(nums));
		System.out.println("Rotated right "+k+" times Array "+Arrays.toString(ra.rotateArrayRight(nums, k)));
		System.out.println("Rotated left "+k+" times Array "+Arrays.toString(ra.rotateArrayLeft(nums, k)));
	}
}
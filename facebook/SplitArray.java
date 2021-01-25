/**

Given an array of integers greater than zero, find if it is possible to split it in two subarrays (without reordering the elements), such that the sum of the two subarrays is the same. Print the two subarrays.

Examples :

Input : Arr[] = { 1 , 2 , 3 , 4 , 5 , 5  }
Output :  { 1 2 3 4 } 
          { 5 , 5 }

Input : Arr[] = { 4, 1, 2, 3 }
Output : {4 1}
         {2 3}

Input : Arr[] = { 4, 3, 2, 1}
Output : Not Possible


**/


public class SplitArray {
	public  boolean splitArray(int[] arr) {
		int sum = 0;
		for(int i : arr){
			sum += i;
		}

		if(sum%2!=0) return false; 

		int half = sum /2;
		int leftSum= sum; 
		int rightSum = 0;
		for(int j=arr.length-1; j>=0; j--){
			if(arr[j]>half) return false;
			rightSum += arr[j];
			leftSum -= arr[j];

			if(rightSum==leftSum) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		SplitArray sa = new SplitArray();
		int arr [] = new int [] {2,1,2,3,4,5,2,3,1,1};
		System.out.println(sa.splitArray(arr));
	}
}
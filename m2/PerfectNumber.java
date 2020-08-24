import java.util.Arrays;

/**

DCP # 420

A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.


**/


class PerfectNumber {
	// returns the interger array correspondig to the imput [] 
	public int[] getPertectNumber(int [] nums){
		int [] resp = new int [nums.length];
		// find the digits in  each  number 
		int counter = 0;
		for(int i : nums){
			 int digSum = getDigitSum(i);
			 if(digSum>10){
			 	 digSum = getDigitSum(digSum);
			 }
			
			System.out.println(" Number : "+i+" sumOfDigits : "+digSum);
			
			resp[counter++] = digSum *10 + 10-digSum;
		}
		return resp;
	}

	private int getDigitSum(int x){
		int sumOfDigits = 0;
		while(x!=0){
				int rem = x %10;
				sumOfDigits = sumOfDigits + rem;
				x = x/10;
		}
		return sumOfDigits;
	}


	public static void main(String[] args) {
		PerfectNumber pn = new PerfectNumber();
		int [] num = new int [] {99999, 1000, 10000, 2, 3, 22, 77, 68, 99};
		System.out.println(Arrays.toString(pn.getPertectNumber(num)));
	}

} 
import java.util.ArrayList;
import java.util.List;

public class IntegerPalindrome{
	/**

	Write a program that checks whether an integer is a palindrome. 
	For example, 121 is a palindrome, as well as 888. 678 is not a palindrome. Do not convert the integer into a string.

	**/

	
	public boolean isPalindrome(int num){
		if(num<0){
			return false;
		}
		int reverserdNum = 0;
		int x = num;
		while(x!=0){
			int digit = x % 10;
			reverserdNum = 10 * reverserdNum + digit;
			x = x / 10;
		}
		if(reverserdNum == num) return true;
		return false;
	}

	public static void main(String[] args) {
		IntegerPalindrome ip = new IntegerPalindrome();
		int num = 10101;
		System.out.println("Is Palindrome : "+ip.isPalindrome(num));
	}
}
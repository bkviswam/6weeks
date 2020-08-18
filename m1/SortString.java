import java.util.Arrays;

/**

Given a string of lowercase characters from ‘a’ – ‘z’. We need to write a program to print the characters of this string in sorted order.

Examples:

Input : bbccdefbbaa 
Output : aabbbbccdef

Input : geeksforgeeks
Output : eeeefggkkorss

**/


class SortString {
	public String sort(String s){
		char [] cArr = s.toCharArray();
		Arrays.sort(cArr);
		return String.valueOf(cArr);
	}
	public static void main(String[] args) {
		SortString ss = new SortString();
		String s = "geeksforgeeks";
		System.out.println("Sorted String :"+ss.sort(s));
	}
}
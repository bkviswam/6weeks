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

	//optimized version 
	public String sortII(String s){
		int [] letters = new int [26];
		//construct the array
		for(char c : s.toCharArray()){
			letters[c-'a']++;
		} 
		//iterrate over the array

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<letters.length; i++){
			for(int j=0; j<letters[i]; j++){
				sb.append((char)(i + 'a'));
			}
		}
		return sb.toString();

	}


	public String sort(String s){
		char [] cArr = s.toCharArray();
		Arrays.sort(cArr);
		return String.valueOf(cArr);
	}
	public static void main(String[] args) {
		SortString ss = new SortString();
		String s = "geeksforgeeks";
		System.out.println("Sorted String :"+ss.sort(s));
		System.out.println("Sorted String :"+ss.sortII(s));
	}
}
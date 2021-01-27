import java.util.Arrays;

/**

186. Reverse Words in a String II  // Medium

Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?

**/


public class ReverseWordsStringII {
	public char[] reverseWords(char[] s){
		swap(s, 0, s.length-1);

		int prev=0;
		for(int i=0; i<=s.length; i++){
			if(i==s.length || s[i]==' '){
				swap(s, prev, i-1);
				prev = i+1;
			}
		}
		return s;
	}
	public void swap(char[] s, int start, int end){
		while(start<end){
			char temp = s[start];
			 s[start] =s[end];
			 s[end] = temp;
			 start++; end--;
		}
	}



	public static void main(String[] args) {
		ReverseWordsStringII rs = new ReverseWordsStringII();
		char[] s = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		System.out.println(Arrays.toString(rs.reverseWords(s)));
	}
}
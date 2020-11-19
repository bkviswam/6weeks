import java.util.Arrays;


/**

186. Reverse Words in a String II // Medium

Given an input string , reverse the string word by word. 

Example:

Input:  ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?

**/


public class ReverseWordsII {
	public static void main(String[] args) {
		ReverseWordsII rII = new ReverseWordsII();
		char[] s = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		rII.reverseWords(s);
		System.out.println(Arrays.toString(s));
	}
	public void reverseWords(char[] s){
		reverse(s, 0, s.length-1);
		int prev = 0;
		for(int i = 0; i <= s.length; i++){
			if(i==s.length || s[i]==' '){
				reverse(s, prev, i-1);
				prev = i+1;
			}
		}
	}

	private void reverse(char [] s, int start, int end){
		while(start < end){
			char t = s[start];
			s[start] = s[end];
			s[end] = t;
			start++;
			end--;
		}
	}
}
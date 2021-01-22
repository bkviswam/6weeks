/**

Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

Insert exactly one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.
 

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "a", t = ""
Output: true
Example 4:

Input: s = "", t = "A"
Output: true
 

Constraints:

0 <= s.length <= 104
0 <= t.length <= 104
s and t consist of lower-case letters, upper-case letters and/or digits.

**/


public class OneEditDistance {
	private boolean isOneEditDistance(String s, String t){
		if(s.equals(t) || Math.abs(s.length()- t.length())>1) return false;

		int len1 = s.length();
		int len2 = t.length();

		int distance = 0;

		for(int i=0, j=0; i<len1 && j<len2; i++,j++){
			if(s.charAt(i)!=t.charAt(j)){
				distance++;
			}
			if(len1> len2 && s.charAt(i)!=t.charAt(j)){
				j--;
			}else if(len1 < len2 && s.charAt(i)!=t.charAt(j)){
				i--;
			}

			if(distance>1) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		OneEditDistance od = new OneEditDistance();
		String s = "abc";
		String t = "ab";
		System.out.println("One edit distance "+od.isOneEditDistance(s, t));
	}
}
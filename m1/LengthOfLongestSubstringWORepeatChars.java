import java.util.Set;
import java.util.HashSet;

class LengthOfLongestSubstringWORepeatChars {
	
	/**

	3. Longest Substring Without Repeating Characters

	Given a string, find the length of the longest substring without repeating characters.

	Example 1:

	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
	Example 2:

	Input: "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
	Example 3:

	Input: "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


    **/

	public int lengthOfLongestSubstring(String s){
		Set<Character> set = new HashSet<Character>();
		int n = s.length();
		int ans = 0;
		int i = 0;
		int j = 0;
		while(i < n && j < n){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstringWORepeatChars l = new LengthOfLongestSubstringWORepeatChars();
		String s = "pwwkew";
		System.out.println(l.lengthOfLongestSubstring(s));
	}

}
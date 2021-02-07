import java.util.Arrays;

/**

821. Shortest Distance to a Character  // Easy

Given a string s and a character c that occurs in s, return an array of integers answer 
where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.


Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 

Constraints:

1 <= s.length <= 104
s[i] and c are lowercase English letters.
c occurs at least once in s.

**/

public class ShortestDistanceToAChar{

	private int[] shortestToChar(String s, char c){
		int [] result = new int[s.length()];
		for(int i=0; i<result.length; i++){
			int left = s.substring(0, i).lastIndexOf(c);
			int right = s.substring(i).indexOf(c);
			if(left > -1 && right > -1){
				result[i] = Math.min(i-left, right);
			}else if (left > -1){
				result[i] = i-left;
			}else if (right > -1){
				result[i] = right;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ShortestDistanceToAChar sc = new ShortestDistanceToAChar();
		String s = "leetcode";
		char c = 'e';
		System.out.println(Arrays.toString(sc.shortestToChar(s, c)));
	}
}
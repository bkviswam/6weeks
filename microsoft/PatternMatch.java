import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


/**

Given a string and a pattern, find the starting indices of all occurrences of the pattern in the string.
For example, given the string "abracadabra" and the pattern "abr", you should return [0, 7].
**/

public class PatternMatch {
	// Naive solution
	private int[] patternMatch(String str, String s){
		List<Integer> lst = new ArrayList<>();
		for(int i=0; i<str.length()-s.length()+1; i++){
			if(str.substring(i, i+s.length()).equals(s)){
				lst.add(i);
			}
		}
		int [] arr = new int[lst.size()];
		int count = 0;
		for(int i : lst){
			arr[count++] = i;
		}
		return arr;
	}
	// compute lps[]
	private int[] computeTemporaryArray(char pattern[]){
		int lps[] = new int[pattern.length];
		int index=0;

		for(int i=1; i<pattern.length;){
			if(pattern[i]==pattern[index]){
				lps[i]=index+1;
				index++;
				i++;
			}else{
				if(index != 0){
					index = lps[index -1];
				}else{
					lps[i] = 0;
					i++;
				}	
			}
		}
		System.out.println(Arrays.toString(lps));
		return lps;
	}
	public int[] kmp(String str, String s){
		int [] lps = computeTemporaryArray(s.toCharArray());
		char[] text = str.toCharArray();
		char[] pattern = s.toCharArray();
		List<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i< text.length && j<pattern.length){
			if(text[i]==pattern[j]){
				i++;
				j++;
			}else{
				if(j!=0){
					j=lps[j-1];
				}else{
					i++;
				}
			}
			if(j == pattern.length){
				list.add(i-j);
				j=0;
			}
		}

		int ret[] = new int[list.size()];
		int counter = 0;

		for(int k : list) {
			ret[counter++] = k;
		}

		return ret;
	}

	public static void main(String[] args) {
		PatternMatch pm = new PatternMatch();
		String str = "aabaacaadaabaac";
		String s = "aabaa";
		//System.out.println(Arrays.toString(pm.patternMatch(str, s)));
		System.out.println(Arrays.toString(pm.kmp(str, s)));

	}
}
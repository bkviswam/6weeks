import java.util.Map;
import java.util.HashMap;


/**

Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.

**/

public class NonDupeInteger{
	//o(n) time, o(1) space
	public int getNonDuplicteIntEff(int [] nums){
		int ones = 0;
		int twos = 0;
		int not_threes;
		for(int num : nums){
			twos = twos | (ones & num);
			ones = ones ^ num;
			not_threes = ~(ones & twos);
			ones &= not_threes;
			twos &= not_threes;
		}
		return ones;
	}

	//o(n) time, o(n) space
	public int getNonDuplicteInt(int [] nums){
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums){
			if(!map.containsKey(num)){
				map.put(num, 1);
			}else{
				int count = map.get(num);
				if(count==2){
					map.remove(num);
				}else{
					map.put(num, count+1);
				}
			}
		}
		Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
		return entry.getKey();
	}
	public static void main(String[] args) {
		NonDupeInteger nd = new NonDupeInteger();
		//int [] nums = new int[]{6, 1, 3, 3, 3, 6, 6};
		//int [] nums = new int[]{12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
		int [] nums = new int[]{10, 20, 10, 30, 10, 30, 30};
		System.out.println(nd.getNonDuplicteInt(nums));
		System.out.println(nd.getNonDuplicteIntEff(nums));
	}
}
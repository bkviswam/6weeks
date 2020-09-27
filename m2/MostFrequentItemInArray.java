import java.util.HashMap;

/** 

Find Most frequent item in an array

**/

public class MostFrequentItemInArray{
	public int findMostFrequent(int[] nums){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max_count = -1 ; 
		int max_Item = 0 ;
		for(int i : nums){
			if(!map.containsKey(i)){
				map.put(i, 1);
			}else {
				map.put(i,map.get(i)+1);
			}
			if(map.get(i) > max_count){
				max_count = map.get(i);
				max_Item = i;
			}
		}
		return max_Item;
	}
	public static void main(String[] args) {
		MostFrequentItemInArray mf = new MostFrequentItemInArray();
		int [] nums = new int[] {5, 3, 5, 5, 2,1,1,1,3,2,3,5};
		System.out.println(mf.findMostFrequent(nums));
	}
}
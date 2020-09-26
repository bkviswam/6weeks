import java.util.HashMap;

/** 

Find Most frequent item in an array

**/

public class MostFrequentItemInArray{
	public int findMostFrequent(int[] nums){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max_count = 0 ; 
		int max_Item = 0 ;
		for(int i : nums){
			if(!map.containsKey(i)){
				map.put(i, 1);
			}else {
				int max = map.get(i)+1;
				map.put(i, max);
				if(max >max_count){
					max_count = max;
					max_Item = i;
				}

			}
		}
		return max_Item;
	}
	public static void main(String[] args) {
		MostFrequentItemInArray mf = new MostFrequentItemInArray();
		int [] nums = new int[] {1, 5, 5, 3, 5, 5, 1,2,1,1,1,3,1,3,2,3,5};
		System.out.println(mf.findMostFrequent(nums));
	}
}
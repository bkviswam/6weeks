import java.util.ArrayList;
import java.util.List;

public class PowerSet{

	public List<List<Integer>> getPowerSet(int [] nums){
		List<List<Integer>> res = new ArrayList<>();
		combinations(nums, 0, res, new ArrayList<Integer>());
		return res;
	}

	public void combinations(int[] nums, int i, List<List<Integer>> res, List<Integer> path){
		if(i == nums.length){
			res.add(path);
			return;
		}

		List<Integer> pathWithCurrent = new ArrayList<>(path);
		pathWithCurrent.add(nums[i]);	
		//exclude the current item
		combinations(nums, i+1, res, path);
		//include the current item
		combinations(nums, i+1, res, pathWithCurrent);

	}

	public static void main(String[] args) {
		PowerSet pow = new PowerSet();
		int [] nums = new int[] {1,2,3};
		List<List<Integer>> result = pow.getPowerSet(nums);
		System.out.println(result);
	}
}
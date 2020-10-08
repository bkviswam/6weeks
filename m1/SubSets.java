import java.util.List;
import java.util.ArrayList;

/**

78. Subsets -- Medium

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

**/ 


public class SubSets {
	
	public List<List<Integer>> subset(int [] nums){
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
		return subsets;
	}

	private void generateSubsets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subsets){
		subsets.add(new ArrayList<Integer>(current));
		for(int i=index; i<nums.length; i++){
			current.add(nums[i]);
			generateSubsets(i+1, nums, current, subsets);
			current.remove(current.size()-1);
		}
	}

	public static void main(String[] args) {
		int [] nums = new int [] {1,2,3,4,5,6};
		SubSets  ss = new SubSets();
		List<List<Integer>> subsets = ss.subset(nums);
		for (List<Integer> result : subsets) {
			System.out.println(result);
		}
	}
}
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;

public class FirstUnique{

	Set<Integer> set = new LinkedHashSet<>();
	Map<Integer, Boolean> isUnique = new HashMap<>();

	public FirstUnique(int[] nums){
		for(int num : nums){
			this.add(num);
		}
	}

	public int showFirstUnique(){
		if(!set.isEmpty()){
			return set.iterator().next();
		}
		return -1;
	}

	public void add(int value){
		if(!isUnique.containsKey(value)){
			isUnique.put(value,true);
			set.add(value);
		}else{
			isUnique.put(value,false);
			set.remove(value);
		}
	}

	public static void main(String[] args) {
		int nums[] = new int [] {2,3,5};
		FirstUnique fu = new FirstUnique(nums);
		System.out.println(fu.showFirstUnique());
		fu.add(5);
		System.out.println(fu.showFirstUnique());
		fu.add(2);
		System.out.println(fu.showFirstUnique());
		fu.add(3);
		System.out.println(fu.showFirstUnique());
	}

}
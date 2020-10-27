import java.util.ArrayList;
import java.util.List;

public class PowerSetString {
	public static void main(String[] args) {
		PowerSetString pow = new PowerSetString();
		String [] menu = new String[] {"lettuce","tomato","carrot"};
		List<List<String>> result = pow.getPowerSet(menu);
		System.out.println(result);
	}

	private List<List<String>> getPowerSet(String[] menu) {
		List<List<String>> res = new ArrayList<>();
		combination(menu, 0, res, new ArrayList<>());
		return res;
	}

	private void combination(String[] menu, int i, List<List<String>> res, ArrayList<String> path) {
		if(menu.length==i) {
			res.add(path);
			return;
		}
		ArrayList<String> pwc = new ArrayList<String>(path);
		pwc.add(menu[i]);
		
		combination(menu, i+1, res, path);
		combination(menu, i+1, res, pwc);
	}
}

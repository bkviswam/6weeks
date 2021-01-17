import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);

		LinkedList<int[]> merged = new LinkedList<>();

		for(int[] interval : intervals){
			if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
				merged.add(interval);
			}else{
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int [][] intervals  = new int[][]{{7,15},{1,4},{4,5},{5,9},{10,12}};
		System.out.println(Arrays.deepToString(mi.merge(intervals)));
	}
}
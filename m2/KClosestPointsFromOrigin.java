import java.util.PriorityQueue;

public class KClosestPointsFromOrigin {
	private int[][] findClosestPoints(int[][] points, int k) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
		for(int[]point : points){
			maxHeap.add(point);
			if(maxHeap.size() > k){
				maxHeap.remove();
			}
		}

		int[][] result = new int[k][2];

		while(k-- > 0){
			result[k] = maxHeap.remove();
		}
		return result;
	}


	public static void main(String[] args) {
		KClosestPointsFromOrigin ck = new KClosestPointsFromOrigin();
		int [][] points = new int [][] {{1,3},{-2,2},{1,2},{3,1},{2,3}};
		int k = 3;
		ck.printGrid(ck.findClosestPoints(points, k), k);
	}
	
	public void printGrid(int[][] points, int k){
	   for(int i = 0; i < points.length; i++){
		   System.out.print("[");
	      for(int j = 0; j < points[i].length; j++){
	         System.out.print(" "+points[i][j]);
	      }
	      System.out.print("]");
	      System.out.println();
	   }
	}
}
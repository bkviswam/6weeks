import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime {

	public int findNetworkDelay(int[][] times, int n, int k){
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for(int[] edge : times){
			if(!graph.containsKey(edge[0])){
				graph.put(edge[0], new ArrayList<int[]>());
			}
			graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
		}

		PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
		heap.offer(new int[]{0,k});

		Map<Integer, Integer> dist = new HashMap<>();

		while(!heap.isEmpty()){
			int [] info = heap.poll();
			int d = info[0], node = info[1];
			if(dist.containsKey(node)) continue;
			dist.put(node, d);
			if(graph.containsKey(node)){
				for(int[] edge : graph.get(node)){
					int nei  = edge[0], d2 = edge[1];
					if(!dist.containsKey(nei)){
						heap.offer(new int[] {d+d2, nei});
					}
				}
			}
		}

		if(dist.size() !=n) return -1;
		int ans = 0;

		for(int c : dist.values()){
			ans = Math.max(ans, c);
		}

		return ans;
	}



	public static void main(String[] args) {
		NetworkDelayTime ntd = new NetworkDelayTime();
		int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
		int n =4;
		int k =2;
		System.out.println(ntd.findNetworkDelay(times, n, k));
	}
}
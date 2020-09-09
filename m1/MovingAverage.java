import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class MovingAverage{
	int size, windowSum, count = 0;
	Deque<Integer> queue = new ArrayDeque<Integer>();
	//List<Integer> queue = new ArrayList<Integer>();   // o(n) solution
	public MovingAverage(int size){
		this.size = size;
	}	

	// optimal solution 
	public double next(int val){
		++count;
		queue.add(val);
		int tail = count > size ? (int) queue.poll() : 0;
		windowSum = windowSum - tail + val; 
		return windowSum * 1.0 / Math.min(size, count);
	}

	public static void main(String[] args) {
		MovingAverage  ma = new MovingAverage(3	);
		//System.out.println(ma.next(3));
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));
	}
}
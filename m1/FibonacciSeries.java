import java.util.Arrays;

public class FibonacciSeries {
	public static void main(String[] args) {
		FibonacciSeries fc = new FibonacciSeries();
		int n = 12;
	 	System.out.println(fc.fibo(n));
	}
	private int fibo(int n){
		return fibom(n, new int[n+1]);
	}

	private int fibom(int n, int[] memo){
		if(n<=0){
			return 0;
		}else if(n==1){
			return 1;
		}else if(memo[n]==0){
			memo[n] = fibom(n-1,memo)+fibom(n-2,memo);
		}
		return memo[n];
	}
}
/**

Compute product - sum of a number.
For example, given 123456, product would be 1x2x3x4x5x6 = 720, sum would be 1+2+3+4+5+6 = 21, return product - sum

**/

public class ProductMinusSum{
	private int productMinusSum(int n){
		int sum =0;
		int product = 1;
		while(n!=0){
			int digit = n%10;
			sum += digit;
			product *= digit;
			n = n/10;
		}
		return product-sum;
	}

	public static void main(String[] args) {
		ProductMinusSum pm = new ProductMinusSum();
		int n = 123456;
		System.out.println(pm.productMinusSum(n));
	}	
}
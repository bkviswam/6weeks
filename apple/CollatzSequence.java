/**


A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:

if n is even, the next number in the sequence is n / 2
if n is odd, the next number in the sequence is 3n + 1
It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.

Bonus: What input n <= 1000000 gives the longest sequence?

**/


public class CollatzSequence {
	public void checkCollatzSequence(int n){
		while(n!=1){
			System.out.print(n+" ");
			if(n%2==0) {
				n = n/2;
			}else{
				n = 3 * n + 1;
			}
		}
		System.out.print(n+"\n");
	}
	public static void main(String[] args) {
		CollatzSequence cs = new CollatzSequence();
		int n = 1000000;
		cs.checkCollatzSequence(n);
	}
}
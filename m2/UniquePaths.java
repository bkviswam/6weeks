
/**

62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

**/

public class UniquePaths{
	public int uniquePaths(int m, int n) {
       int [][] memo = new int[m][n];
        return uniquePaths(memo, m-1, n-1);
    }
    private int uniquePaths(int [][] memo, int row, int col) {
        if(row==0 || col==0){
            return memo[row][col]=1;
        }
        if(memo[row][col]!=0){
            return memo[row][col];
        }
        return memo[row][col] = uniquePaths(memo,row, col-1)+uniquePaths(memo, row-1, col);
    }
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		int m =3; int n=7;
		System.out.println(up.uniquePaths(m,n));
	}
}
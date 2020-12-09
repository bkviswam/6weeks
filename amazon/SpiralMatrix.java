import java.util.ArrayList;
import java.util.List;

/**

Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

For example, given the following matrix:

[[1,  2,  3,  4,  5],
 [6,  7,  8,  9,  10],
 [11, 12, 13, 14, 15],
 [16, 17, 18, 19, 20]]
You should print out the following:

1
2
3
4
5
10
15
20
19
18
17
16
11
6
7
8
9
14
13
12

**/


public class SpiralMatrix {


	public List<Integer> spiralOrder(int[][] matrix){

		List<Integer> nums = new ArrayList<>();

		if(matrix == null || matrix.length==0){
			return nums;
		}
		
		int top = 0;
		int bottom = matrix.length -1;
		int left = 0;
		int right = matrix[0].length - 1;
	
		int size = matrix.length * matrix[0].length;

		while(nums.size() < size) {

			for(int i=left; i <= right && nums.size() < size; i++){
				nums.add(matrix[top][i]);
			}
			top++;
			for(int i=top; i <= bottom && nums.size() < size; i++){
				nums.add(matrix[i][right]);
			}
			right--;
			for(int i=right; i >= left && nums.size() < size; i--){
				nums.add(matrix[bottom][i]);
			}
			bottom--;
			for(int i=bottom; i>=top && nums.size() < size; i--){
				nums.add(matrix[i][left]);
			}
			left++;

		}
		return nums;

	}


	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = new int[][]{{1,  2,  3,  4,  5},
 									{6,  7,  8,  9,  10},
 									{11, 12, 13, 14, 15},
 									{16, 17, 18, 19, 20}};

 		for(int i=0; i<matrix.length; i++){
 			for(int j =0; j< matrix[0].length; j++){
 				System.out.print(matrix[i][j]+"  ");
 			}
 			System.out.println();
 		}

 		for (int l : sm.spiralOrder(matrix)){
 			System.out.print(l+" ");
 		}

	}
}
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class SortMatrixDiagonally{

	public int[][] diagonalSort(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			sortHelper(i, 0, matrix);
		}
		for(int j=1; j<matrix[0].length; j++){
			sortHelper(0, j, matrix);
		}
		return matrix;
	}


	private void sortHelper(int i, int j, int[][] matrix){
		List<Integer> list = new ArrayList<>();
		int x = i;
		int y = j;

		while(x<matrix.length && y<matrix[0].length){
			list.add(matrix[x++][y++]);
		}
		Collections.sort(list);

		x = i;
		y = j;
		int index = 0;
		while(x<matrix.length && y<matrix[0].length){
			matrix[x++][y++] = list.get(index++);
		}
	}

	public static void main(String[] args) {
		SortMatrixDiagonally sm = new SortMatrixDiagonally();
		int matrix[][] = new int[][]{{3,3,1,1},
									 {2,2,1,2},
									 {1,1,1,2}};

		System.out.println(Arrays.deepToString(sm.diagonalSort(matrix)));
	}
}

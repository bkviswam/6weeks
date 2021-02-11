import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/**

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the 
grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another 
if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.

**/

public class NumberOfDistIslands{
	Set<List<Integer>> set = new HashSet<>();
	public int numDistinctIslands(int[][] grid) {
        for(int i=0; i<grid.length; i++){
        	for(int j=0; j<grid[0].length; j++){
        		if(grid[i][j]==1){
        			List<Integer> list = new ArrayList<>();
        			dfs(grid, list, i, j, 0, 0, 0, 0);
        			set.add(list);
        		}
         	}
        }
        return set.size();
    }

    public void dfs(int[][] grid, List<Integer> list, int i, int j, int up, int right, int down, int left){
    	if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j]==0){
    		return;
    	}
    	grid[i][j] = 0;
    	int position = up*1000000 + right*10000 + down*100 + left ;
        list.add(position);

    	dfs(grid, list, i-1, j, up+1, right, down, left);
        dfs(grid, list, i, j+1, up, right+1, down, left);
        dfs(grid, list, i+1, j, up, right, down+1, left);
        dfs(grid, list, i, j-1, up, right, down, left+1);
        
    	return;

    }

   public static void main(String[] args) {
		NumberOfDistIslands nd = new NumberOfDistIslands();
		int [][] grid = new int [][] {{1,1,0,0,0},
									  {1,1,0,0,0},
									  {0,0,0,1,1},
									  {0,0,0,1,1}};
		System.out.println(nd.numDistinctIslands(grid));
    }
}
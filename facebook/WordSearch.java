/**

79. Word Search  // Medium -- https://leetcode.com/problems/word-search/

	
Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 200
1 <= word.length <= 103
board and word consists only of lowercase and uppercase English letters.

**/

public class WordSearch {
	public boolean exist(char[][] board, String word){
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
		 		if(board[i][j]==word.charAt(0) && dfs(board, word, 0, i, j)){
		 			return true;
		 		}
		    }
		}
		return false;
	}

	public boolean dfs(char[][] board, String word, int soFar, int i, int j){
		if(soFar == word.length()){
			return true;
		}
		//boundry check

		if(i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j] != word.charAt(soFar)){
			return false;
		}

		char current = board[i][j];
		board[i][j] = '$';
		// Explore Neighbors
		if(dfs(board, word, soFar+1, i+1, j)) return true;
		if(dfs(board, word, soFar+1, i-1, j)) return true;
		if(dfs(board, word, soFar+1, i, j+1)) return true;
		if(dfs(board, word, soFar+1, i, j-1)) return true;
		 // In case all directions failed
		board[i][j] = current;
		return false;
	}



	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char [][] board = new char[][] {{'A','B','C','E'},
										{'S','F','C','S'},
										{'A','D','E','E'}};

		String word = "ABCCED";

		System.out.println("Found word ? : "+ws.exist(board, word));

	}
}
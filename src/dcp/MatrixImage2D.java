package dcp;

import java.util.Arrays;

/**
 * Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C, replace the color of the given pixel and all adjacent same colored pixels with C.
 * <p>
 * For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:
 * <p>
 * B B W
 * W W W
 * W W W
 * B B B
 * <p>
 * Becomes
 * <p>
 * B B G
 * G G G
 * G G G
 * B B B
 */
public class MatrixImage2D {
    public char[][] replace(char[][] image, int[][] location, char newColor) {
        int row = image.length;
        int col = image[0].length;
        int xpos = location[0][0];
        int ypos = location[0][1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == xpos && j == ypos) {
                    if (image[i][j] != newColor) {
                        dfs(image, i, j, newColor, image[i][j]);
                    }
                }
            }
        }
        return image;
    }

    private void dfs(char[][] image, int i, int j, char newColor, char existingColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j]!=existingColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i + 1, j, newColor, existingColor);
        dfs(image, i - 1, j, newColor, existingColor);
        dfs(image, i, j + 1, newColor, existingColor);
        dfs(image, i, j - 1, newColor, existingColor);
    }
    public static void main(String[] args) {
        MatrixImage2D m = new MatrixImage2D();
        char[][] image = new char[][]{{'B', 'B', 'W'},
                                      {'B', 'B', 'W'},
                                      {'W', 'B', 'W'},
                                      {'B', 'B', 'B'}};
        int[][] location = new int[][]{{0, 0}};
        char color = 'Q';
        System.out.println(Arrays.deepToString(m.replace(image, location, color)));
    }
}

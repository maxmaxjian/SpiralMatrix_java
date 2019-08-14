import java.util.ArrayList;
import java.util.List;

public class Solution1 implements Solution {
    @Override
    public List<Integer> spiralMatrix(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int row = matrix.length, col = row > 0 ? matrix[0].length : 0;
        int i = 0;
        while (row > 0 && col > 0) {
            List<Integer> tmp = spiral(matrix, i, i, row, col);
            result.addAll(tmp);
            row = row > 2 ? row-2 : 0;
            col = col > 2 ? col-2 : 0;
            i++;
        }

        return result;
    }

    private List<Integer> spiral(int[][] matrix, int start_row, int start_col, int row, int col) {
        List<Integer> rs = new ArrayList<>();
        int i = start_row, j = start_col;

        // top left corner
        rs.add(matrix[i][j]);
        // first row
        if (col > 1) {
            int k = 1;
            while (k < col - 1) {
                rs.add(matrix[i][j + k]);
                k++;
            }
            if (k == col - 1) {
                j += k;
                // top right corner
                rs.add(matrix[i][j]);
            }
        }

        // last column
        if (row > 1) {
            int k = 1;
            while (k < row - 1) {
                rs.add(matrix[i + k][j]);
                k++;
            }
            if (k == row - 1) {
                i += k;
                // bottom right corner
                rs.add(matrix[i][j]);
            }
        }

        if (i != start_row && j != start_row) {
            // last row
            int k = 1;
            while (k < col - 1) {
                rs.add(matrix[i][j - k]);
                k++;
            }
            if (k == col - 1) {
                j -= k;
                // bottom left corner
                rs.add(matrix[i][j]);
            }

            // first column
            k = 1;
            while (k < row - 1) {
                rs.add(matrix[i - k][j]);
                k++;
            }
        }

        return rs;
    }
}

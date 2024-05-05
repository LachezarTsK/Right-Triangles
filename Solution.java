
public class Solution {

    private int rows;
    private int columns;

    public long numberOfRightTriangles(int[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;

        int[] horizontalFrequency = new int[columns];
        int[] verticalFrequency = new int[rows];
        recordFrequencyOfOnes(horizontalFrequency, verticalFrequency, matrix);

        return countNumberOfRightTriangles(horizontalFrequency, verticalFrequency, matrix);
    }

    private void recordFrequencyOfOnes(int[] horizontalFrequency, int[] verticalFrequency, int[][] matrix) {
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < columns; ++c) {
                if (matrix[r][c] == 1) {
                    ++horizontalFrequency[c];
                    ++verticalFrequency[r];
                }
            }
        }
    }

    private long countNumberOfRightTriangles(int[] horizontalFrequency, int[] verticalFrequency, int[][] matrix) {
        long numberOfRightTriangles = 0;
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < columns; ++c) {
                if (matrix[r][c] == 1) {
                    numberOfRightTriangles += (horizontalFrequency[c] - 1) * (verticalFrequency[r] - 1);
                }
            }
        }
        return numberOfRightTriangles;
    }
}

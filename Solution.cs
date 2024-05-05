
using System;

public class Solution
{
    private int rows;
    private int columns;
    public long NumberOfRightTriangles(int[][] matrix)
    {
        rows = matrix.Length;
        columns = matrix[0].Length;

        int[] horizontalFrequency = new int[columns];
        int[] verticalFrequency = new int[rows];
        RecordFrequencyOfOnes(horizontalFrequency, verticalFrequency, matrix);

        return CountNumberOfRightTriangles(horizontalFrequency, verticalFrequency, matrix);
    }

    private void RecordFrequencyOfOnes(int[] horizontalFrequency, int[] verticalFrequency, int[][] matrix)
    {
        for (int r = 0; r < rows; ++r)
        {
            for (int c = 0; c < columns; ++c)
            {
                if (matrix[r][c] == 1)
                {
                    ++horizontalFrequency[c];
                    ++verticalFrequency[r];
                }
            }
        }
    }

    private long CountNumberOfRightTriangles(int[] horizontalFrequency, int[] verticalFrequency, int[][] matrix)
    {
        long numberOfRightTriangles = 0;
        for (int r = 0; r < rows; ++r)
        {
            for (int c = 0; c < columns; ++c)
            {
                if (matrix[r][c] == 1)
                {
                    numberOfRightTriangles += (horizontalFrequency[c] - 1) * (verticalFrequency[r] - 1);
                }
            }
        }
        return numberOfRightTriangles;
    }
}

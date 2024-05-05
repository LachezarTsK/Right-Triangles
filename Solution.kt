
class Solution {

    private var rows = 0
    private var columns = 0

    fun numberOfRightTriangles(matrix: Array<IntArray>): Long {
        rows = matrix.size
        columns = matrix[0].size

        val horizontalFrequency = IntArray(columns)
        val verticalFrequency = IntArray(rows)
        recordFrequencyOfOnes(horizontalFrequency, verticalFrequency, matrix)

        return countNumberOfRightTriangles(horizontalFrequency, verticalFrequency, matrix)
    }

    private fun recordFrequencyOfOnes(
        horizontalFrequency: IntArray, verticalFrequency: IntArray, matrix: Array<IntArray>
    ) {
        for (r in 0..<rows) {
            for (c in 0..<columns) {
                if (matrix[r][c] == 1) {
                    ++horizontalFrequency[c]
                    ++verticalFrequency[r]
                }
            }
        }
    }

    private fun countNumberOfRightTriangles(
        horizontalFrequency: IntArray, verticalFrequency: IntArray, matrix: Array<IntArray>
    ): Long {

        var numberOfRightTriangles: Long = 0;
        for (r in 0..<rows) {
            for (c in 0..<columns) {
                if (matrix[r][c] == 1) {
                    numberOfRightTriangles += (horizontalFrequency[c] - 1) * (verticalFrequency[r] - 1)
                }
            }
        }
        return numberOfRightTriangles
    }
}

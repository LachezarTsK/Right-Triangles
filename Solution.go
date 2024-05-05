
package main

var rows int
var columns int

func numberOfRightTriangles(matrix [][]int) int64 {
	rows = len(matrix)
	columns = len(matrix[0])

	horizontalFrequency := make([]int, columns)
	verticalFrequency := make([]int, rows)
	recordFrequencyOfOnes(horizontalFrequency, verticalFrequency, matrix)

	return countNumberOfRightTriangles(horizontalFrequency, verticalFrequency, matrix)
}

func recordFrequencyOfOnes(horizontalFrequency []int, verticalFrequency []int, matrix [][]int) {
	for r := 0; r < rows; r++ {
		for c := 0; c < columns; c++ {
			if matrix[r][c] == 1 {
				horizontalFrequency[c]++
				verticalFrequency[r]++
			}
		}
	}
}

func countNumberOfRightTriangles(horizontalFrequency []int, verticalFrequency []int, matrix [][]int) int64 {
	var numberOfRightTriangles int64 = 0
	for r := 0; r < rows; r++ {
		for c := 0; c < columns; c++ {
			if matrix[r][c] == 1 {
				numberOfRightTriangles += (int64)((horizontalFrequency[c] - 1) * (verticalFrequency[r] - 1))
			}
		}
	}
	return numberOfRightTriangles
}

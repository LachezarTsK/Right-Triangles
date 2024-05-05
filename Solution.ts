
function numberOfRightTriangles(matrix: number[][]): number {
    this.rows = matrix.length;
    this.columns = matrix[0].length;

    const horizontalFrequency = new Array(this.columns).fill(0);
    const verticalFrequency = new Array(this.rows).fill(0);
    recordFrequencyOfOnes(horizontalFrequency, verticalFrequency, matrix);

    return countNumberOfRightTriangles(horizontalFrequency, verticalFrequency, matrix);
};

function recordFrequencyOfOnes(horizontalFrequency: number[], verticalFrequency: number[], matrix: number[][]) {
    for (let r = 0; r < this.rows; ++r) {
        for (let c = 0; c < this.columns; ++c) {
            if (matrix[r][c] === 1) {
                ++horizontalFrequency[c];
                ++verticalFrequency[r];
            }
        }
    }
}

function countNumberOfRightTriangles(horizontalFrequency: number[], verticalFrequency: number[], matrix: number[][]) {
    let numberOfRightTriangles = 0;
    for (let r = 0; r < this.rows; ++r) {
        for (let c = 0; c < this.columns; ++c) {
            if (matrix[r][c] === 1) {
                numberOfRightTriangles += (horizontalFrequency[c] - 1) * (verticalFrequency[r] - 1);
            }
        }
    }
    return numberOfRightTriangles;
}

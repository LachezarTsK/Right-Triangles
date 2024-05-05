
#include <span>
#include <vector>
using namespace std;

class Solution {

    size_t rows{};
    size_t columns{};

public:
    long long numberOfRightTriangles(const vector<vector<int>>& matrix) {
        rows = matrix.size();
        columns = matrix[0].size();

        vector<int> horizontalFrequency(columns);
        vector<int> verticalFrequency(rows);
        recordFrequencyOfOnes(horizontalFrequency, verticalFrequency, matrix);

        return countNumberOfRightTriangles(horizontalFrequency, verticalFrequency, matrix);
    }

    void recordFrequencyOfOnes
    (span<int> horizontalFrequency, span<int> verticalFrequency, span<const vector<int>> matrix) const {

        for (size_t r = 0; r < rows; ++r) {
            for (size_t c = 0; c < columns; ++c) {
                if (matrix[r][c] == 1) {
                    ++horizontalFrequency[c];
                    ++verticalFrequency[r];
                }
            }
        }
    }

    long long countNumberOfRightTriangles
    (span<const int> horizontalFrequency, span<const int> verticalFrequency, span<const vector<int>> matrix) const {

        long long numberOfRightTriangles = 0;
        for (size_t r = 0; r < rows; ++r) {
            for (size_t c = 0; c < columns; ++c) {
                if (matrix[r][c] == 1) {
                    numberOfRightTriangles += (horizontalFrequency[c] - 1) * (verticalFrequency[r] - 1);
                }
            }
        }
        return numberOfRightTriangles;
    }
};

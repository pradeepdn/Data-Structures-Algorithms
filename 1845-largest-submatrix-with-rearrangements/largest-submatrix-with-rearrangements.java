import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        // Step 1: Update matrix to store heights of consecutive 1s
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] += matrix[r - 1][c];
                }
            }
        }

        // Step 2: Process each row to find the largest rectangle
        for (int r = 0; r < rows; r++) {
            // Copy current row heights and sort them
            int[] currentRow = matrix[r].clone();
            Arrays.sort(currentRow);

            // Step 3: Calculate area from tallest to shortest
            // Sorting is ascending, so we iterate backwards
            for (int i = 0; i < cols; i++) {
                int height = currentRow[cols - 1 - i];
                int width = i + 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}
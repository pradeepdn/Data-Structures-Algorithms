class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        // Use a long array to prevent overflow if cell values + k are large
        long[][] prefixSum = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                long currentTotal = grid[i][j];

                // Add top neighbor's prefix sum
                if (i > 0) {
                    currentTotal += prefixSum[i - 1][j];
                }
                
                // Add left neighbor's prefix sum
                if (j > 0) {
                    currentTotal += prefixSum[i][j - 1];
                }
                
                // Subtract top-left diagonal to avoid double counting
                if (i > 0 && j > 0) {
                    currentTotal -= prefixSum[i - 1][j - 1];
                }

                prefixSum[i][j] = currentTotal;

                // Check if the current submatrix sum is within the limit k
                if (currentTotal <= k) {
                    count++;
                } else {
                    // Optimization: since all grid[i][j] >= 0, once a sum 
                    // exceeds k, any further expansion in this row (j++) 
                    // will also exceed k.
                    break; 
                }
            }
        }
        
        return count;
    }
} 
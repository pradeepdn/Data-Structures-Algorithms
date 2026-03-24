class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        long runningProduct = 1;
        int MOD = 12345;

        // Step 1: Forward Pass (Prefix)
        // Store the product of all elements BEFORE the current element
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int) runningProduct;
                runningProduct = (runningProduct * (grid[i][j] % MOD)) % MOD;
            }
        }

        // Step 2: Backward Pass (Suffix)
        // Multiply the existing prefix by the product of all elements AFTER it
        runningProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                res[i][j] = (int) ((res[i][j] * runningProduct) % MOD);
                runningProduct = (runningProduct * (grid[i][j] % MOD)) % MOD;
            }
        }

        return res;
    }
}
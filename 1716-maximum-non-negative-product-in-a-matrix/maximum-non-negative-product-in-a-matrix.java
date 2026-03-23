class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1_000_000_007L;

        // dp[i][j][0] stores the maximum product to reach (i, j)
        // dp[i][j][1] stores the minimum product to reach (i, j)
        long[][][] dp = new long[m][n][2];

        // Initialize starting point
        dp[0][0][0] = dp[0][0][1] = grid[0][0];

        // Fill first column
        for (int i = 1; i < m; i++) {
            long val = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][0] = dp[i][0][1] = val;
        }

        // Fill first row
        for (int j = 1; j < n; j++) {
            long val = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][0] = dp[0][j][1] = val;
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long curr = grid[i][j];
                // Possible products from top and left
                long a = dp[i - 1][j][0] * curr;
                long b = dp[i - 1][j][1] * curr;
                long c = dp[i][j - 1][0] * curr;
                long d = dp[i][j - 1][1] * curr;

                dp[i][j][0] = Math.max(Math.max(a, b), Math.max(c, d));
                dp[i][j][1] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long res = dp[m - 1][n - 1][0];
        return res < 0 ? -1 : (int) (res % MOD);
    }
}
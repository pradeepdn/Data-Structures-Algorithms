class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        // dp[i][j][k] -> max money at (i, j) with k neutralizations USED
        long[][][] dp = new long[m][n][3];
        
        // Initialize with a very small number
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Long.MIN_VALUE / 2);
            }
        }

        // Base case: Starting cell (0,0)
        int startVal = coins[0][0];
        dp[0][0][0] = startVal; // No neutralization
        if (startVal < 0) {
            dp[0][0][1] = 0;    // Used 1 neutralization
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                
                int v = coins[i][j];
                
                for (int k = 0; k < 3; k++) {
                    long prevBest = Long.MIN_VALUE / 2;
                    if (i > 0) prevBest = Math.max(prevBest, dp[i-1][j][k]);
                    if (j > 0) prevBest = Math.max(prevBest, dp[i][j-1][k]);
                    
                    // Option 1: Don't neutralize (or it's a positive value)
                    dp[i][j][k] = Math.max(dp[i][j][k], prevBest + v);
                    
                    // Option 2: Neutralize if it's a robber and we have uses left
                    if (v < 0 && k > 0) {
                        long prevBestKMinus = Long.MIN_VALUE / 2;
                        if (i > 0) prevBestKMinus = Math.max(prevBestKMinus, dp[i-1][j][k-1]);
                        if (j > 0) prevBestKMinus = Math.max(prevBestKMinus, dp[i][j-1][k-1]);
                        
                        dp[i][j][k] = Math.max(dp[i][j][k], prevBestKMinus);
                    }
                }
            }
        }

        // The answer is the maximum of using 0, 1, or 2 neutralizations
        long res = Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
        return (int) res;
    }
}
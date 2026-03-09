class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        // Use long to prevent overflow during additions
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base Case: Starting point
        // Empty array isn't usually counted, so we start with 1 element
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int z = 1; z <= zero; z++) {
            for (int o = 1; o <= one; o++) {
                
                // --- Calculating dp[z][o][0] (Ending in 0) ---
                // We can add a 0 to any stable array ending in 0 or 1
                dp[z][o][0] = (dp[z - 1][o][0] + dp[z - 1][o][1]) % MOD;
                
                if (z > limit) {
                    // Subtract arrays that would now have (limit + 1) zeros.
                    // This only happens if the array was [...1][0][0...limit-1 zeros]
                    // So we look back to when the last digit was a '1'.
                    long illegal = dp[z - limit - 1][o][1];
                    dp[z][o][0] = (dp[z][o][0] - illegal + MOD) % MOD;
                }

                // --- Calculating dp[z][o][1] (Ending in 1) ---
                dp[z][o][1] = (dp[z][o - 1][0] + dp[z][o - 1][1]) % MOD;
                
                if (o > limit) {
                    // Subtract arrays that would now have (limit + 1) ones.
                    long illegal = dp[z][o - limit - 1][0];
                    dp[z][o][1] = (dp[z][o][1] - illegal + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
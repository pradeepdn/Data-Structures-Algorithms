class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        // Using two 2D arrays to save space and clarify logic
        long[][] zeroDP = new long[zero + 1][one + 1];
        long[][] oneDP = new long[zero + 1][one + 1];

        // Base cases: Pure streaks of 0s or 1s up to the limit
        for (int i = 1; i <= Math.min(zero, limit); i++) zeroDP[i][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) oneDP[0][j] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // To end in 0:
                // We add a 0 to any stable array of (i-1, j)
                zeroDP[i][j] = (zeroDP[i - 1][j] + oneDP[i - 1][j]) % MOD;
                if (i > limit) {
                    // Subtract cases where we just created a streak of (limit + 1) zeros
                    // These cases must have ended in a 1 before the streak started.
                    zeroDP[i][j] = (zeroDP[i][j] - oneDP[i - limit - 1][j] + MOD) % MOD;
                }

                // To end in 1:
                // We add a 1 to any stable array of (i, j-1)
                oneDP[i][j] = (oneDP[i][j - 1] + zeroDP[i][j - 1]) % MOD;
                if (j > limit) {
                    // Subtract cases where we just created a streak of (limit + 1) ones
                    oneDP[i][j] = (oneDP[i][j] - zeroDP[i][j - limit - 1] + MOD) % MOD;
                }
            }
        }

        return (int) ((zeroDP[zero][one] + oneDP[zero][one]) % MOD);
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Use a primitive int array to avoid Integer object overhead
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            // Get the current row once to reduce .get() calls
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                // Primitive math is significantly faster than object method calls
                dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}

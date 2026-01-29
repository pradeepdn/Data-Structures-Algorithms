class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Create an array based on the bottom row size
        int[] dp = new int[n + 1];

        // Start from the bottom row and move up
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // dp[j] is updated using the values from the "row below" 
                // which are currently stored in dp[j] and dp[j+1]
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
                System.out.println(dp[j]);
            }
        }
        return dp[0];
    }
}

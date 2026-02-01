class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        dp[0] = 1;
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int num : dp) {
            result.add(num);
        }
        return result;
    }
}
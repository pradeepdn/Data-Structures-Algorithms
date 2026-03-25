class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long sum = 0;
        int vertical[] = new int[n];
        int horizontal[] = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vertical[j] += grid[i][j];
                horizontal[i] += grid[i][j];
                sum += grid[i][j];
            }
        }
        if (sum % 2 != 0)
            return false;
        long target = sum / 2;
        for (int i = 0; i < n - 1; i++) {
            sum -= vertical[i];
            if (sum == target) {
                return true;
            }

        }
        sum = target * 2;
        for (int i = 0; i < m - 1; i++) {
            sum -= horizontal[i];
            if (sum == target) {
                return true;
            }
        }
        return false;
    }
}
import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                ans[i][j] = getMinDist(grid, i, j, k);
            }
        }
        return ans;
    }

    private int getMinDist(int[][] grid, int r, int c, int k) {
        List<Integer> vals = new ArrayList<>();
        
        // 1. Collect all k*k elements
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                vals.add(grid[i][j]);
            }
        }

        // 2. Sort to make finding differences easy
        Collections.sort(vals);

        int minDiff = Integer.MAX_VALUE;
        boolean foundDistinct = false;

        // 3. Compare adjacent distinct values
        for (int i = 1; i < vals.size(); i++) {
            if (!vals.get(i).equals(vals.get(i - 1))) {
                int diff = Math.abs(vals.get(i) - vals.get(i - 1));
                minDiff = Math.min(minDiff, diff);
                foundDistinct = true;
            }
        }

        // 4. Return 0 if all values were the same, else return the min diff
        return foundDistinct ? minDiff : 0;
    }
}
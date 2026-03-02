class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailingZeros[i] = count;
        }
        int totalSwaps = 0;
        // Step 2: Greedy selection and Bubble Sort
        for (int i = 0; i < n; i++) {
            int target = n - 1 - i;
            int foundIdx = -1;
            
            // Find the first available row that satisfies the target
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= target) {
                    foundIdx = j;
                    break;
                }
            }
            if (foundIdx == -1) return -1; // Impossible
            
            // Swap adjacent rows to move foundIdx to i
            for (int j = foundIdx; j > i; j--) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                totalSwaps++;
            }
        }
        
        return totalSwaps;
    }
}
import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        // TreeSet stores unique sums. 
        // Using reverseOrder() keeps the largest sums at the front.
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 1. Add the single-cell rhombus (radius 0)
                set.add(grid[i][j]);

                // 2. Try expanding the radius L
                // The tips are: (i-L, j), (i+L, j), (i, j-L), (i, j+L)
                for (int L = 1; i - L >= 0 && i + L < m && j - L >= 0 && j + L < n; L++) {
                    int currentSum = 0;

                    // Walk all 4 edges of the rhombus
                    // Each loop adds L numbers, effectively covering one side 
                    // and one corner, preventing double-counting of tips.
                    for (int k = 0; k < L; k++) {
                        currentSum += grid[i - L + k][j + k]; // Top to Right
                        currentSum += grid[i + k][j + L - k]; // Right to Bottom
                        currentSum += grid[i + L - k][j - k]; // Bottom to Left
                        currentSum += grid[i - k][j - L + k]; // Left to Top
                    }

                    set.add(currentSum);

                    // Optional: keep the set size small to optimize memory
                    // If we have more than 3, we don't need the smallest one anymore
                    if (set.size() > 100) { // Safety buffer before trimming
                         // Trimming happens at the end for simplicity, 
                         // but you could pollLast() here.
                    }
                }
            }
        }

        // 3. Extract the top 3 unique sums
        List<Integer> resultList = new ArrayList<>();
        while (!set.isEmpty() && resultList.size() < 3) {
            resultList.add(set.pollFirst()); // pollFirst because we used reverseOrder()
        }

        // Convert List to int array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
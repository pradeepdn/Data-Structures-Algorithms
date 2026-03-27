class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // If k is a multiple of n, the row shifts back to its original position
        k = k % n;
        if (k == 0) return true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    // Even row: Left shift
                    // Check if current element matches the element k positions to its right
                    if (mat[i][j] != mat[i][(j + k) % n]) return false;
                } else {
                    // Odd row: Right shift
                    // Check if current element matches the element k positions to its left
                    if (mat[i][j] != mat[i][(j - k + n) % n]) return false;
                }
            }
        }
        return true;
    }
}
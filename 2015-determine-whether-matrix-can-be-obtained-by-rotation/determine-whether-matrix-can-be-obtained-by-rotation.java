class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length; 
        boolean[] c = new boolean[4];
        for(int i = 0; i < 4; i++) c[i] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) c[0] = false;
                // Check 90 degrees clockwise
                if (mat[n - 1 - j][i] != target[i][j]) c[1] = false;
                // Check 180 degrees
                if (mat[n - 1 - i][n - 1 - j] != target[i][j]) c[2] = false;
                // Check 270 degrees clockwise
                if (mat[j][n - 1 - i] != target[i][j]) c[3] = false;
            }
        }
        return c[0] || c[1] || c[2] || c[3];
    }
}
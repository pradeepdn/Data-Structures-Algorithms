class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int spec = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    spec++;
                }
            }
        }
        return spec;
    }
}
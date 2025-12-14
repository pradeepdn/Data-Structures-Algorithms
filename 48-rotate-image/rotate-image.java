class Solution {
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (i != j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            for (int j = 0; j < matrix.length; j++) {
                temp = matrix[j][left];
                matrix[j][left] = matrix[j][right];
                matrix[j][right] = temp;
                System.out.println(matrix[j][right]);
            }
            left++;
            right--;
        }
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;

        while (m >= 0 && n >= 0 && m <= matrix.length - 1 && n <= matrix[0].length - 1) {

            int mid = matrix[m][n];
            if (mid == target) {
                return true;
            } else if (target > mid) {
                m++;
            } else if (target < mid) {
                n--;
            }
        }
        return false;
    }
}
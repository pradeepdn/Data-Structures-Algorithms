class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**Optimal Binary Search */
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target)
                return true;
            else if (midVal < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

    /**Version 1 linear search */

    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             if (matrix[i][j] == target)
    //                 return true;
    //         }
    //     }
    //     return false;
    // }

    /**Version 2 looking for the right colum */
    //     int i = 0;
    //     while (i + 1 < matrix.length && matrix[i + 1][0] <= target) {
    //         i++;
    //     }
    //     for (int j = 0; j < matrix[0].length; j++) {
    //         if (matrix[i][j] == target)
    //             return true;
    //     }
    //     return false;
    // }
}
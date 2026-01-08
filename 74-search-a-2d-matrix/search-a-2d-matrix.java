class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    /**Version 1 linear search */

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

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
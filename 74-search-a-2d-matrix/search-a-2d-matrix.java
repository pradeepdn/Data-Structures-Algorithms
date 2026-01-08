class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while(i+1 < matrix.length && matrix[i+1][0] <= target){
            System.out.println(matrix[i][0]);
            i++; 
        }
        // for(int i =0; i<matrix.length; i++){
             for(int j= 0; j<matrix[0].length; j++){
                 if(matrix[i][j] == target) return true; 
            }
        // }
        return false;
    }
}
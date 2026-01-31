class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j == 0) continue; // Skip the start
                
                if(i == 0) {
                    // First row: can only come from left
                    grid[i][j] += grid[i][j-1];
                } else if(j == 0) {
                    // First column: can only come from top
                    grid[i][j] += grid[i-1][j];
                } else {
                    // Middle of grid: pick the cheaper path
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
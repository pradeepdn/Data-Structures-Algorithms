class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int c = matrix[0].length;
        int r = matrix.length;
        int right = c - 1;
        int bottom = r - 1;
        int left = 0;
        int top = 0;

        List<Integer> spiralOrder = new ArrayList<Integer>(r * c);

        while (top<=bottom && left<=right){

            for(int col = left ; col<=right; col++){
                spiralOrder.add(matrix[top][col]);
            }
            top++;
            for(int row = top; row<=bottom; row++){
                spiralOrder.add(matrix[row][right]);
            }
            right--;
            if(top<=bottom){
                for(int col=right;col>=left; col--){
                    spiralOrder.add(matrix[bottom][col]);
                }
                bottom--;
            }
            if(left<=right){
                for(int row = bottom; row>=top; row--){
                    spiralOrder.add(matrix[row][left]);
                }
                left++;
            }
        }
        return spiralOrder;
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Start from the second-to-last row and move upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // The min path at this spot is:
                // current value + min(value below-left, value below-right)
                int minBelow = Math.min(
                    triangle.get(i + 1).get(j), 
                    triangle.get(i + 1).get(j + 1)
                );
                
                int currentVal = triangle.get(i).get(j);
                triangle.get(i).set(j, currentVal + minBelow);
            }
        }
        // The answer will be stored at the very top
        return triangle.get(0).get(0);
    }
}
class Solution {
    public int maxArea(int[] height) {
        int capacity=0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int min = Math.min(height[left], height[right]);
            capacity = Math.max(capacity, (min * (right-left)));
            if(height[left]<height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return capacity;
    }
}

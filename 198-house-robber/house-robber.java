class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int prev1 = 0;
        int prev2 = 0;
        for(int currValue : nums){
            int currMax = Math.max(prev1, currValue + prev2);
            prev2 = prev1;
            prev1 = currMax;
        }
        return prev1;
    }
}
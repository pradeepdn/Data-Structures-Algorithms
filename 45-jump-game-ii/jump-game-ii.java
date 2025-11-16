class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int jump = 0;
        int currentEnd = 0;
        for(int i=0;i < nums.length-1; i++){
            maxReach=Math.max(maxReach, i+nums[i]);
            if(currentEnd == i){
                jump++;
                currentEnd = maxReach;
            }
        }
    return jump;        
    }
}
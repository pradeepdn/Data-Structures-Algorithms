class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (p != -1) {
                    if ((i - p - 1) < k) {
                        return false;
                    }
                }
                p = i;
            }
        }
        return true;
    }
}
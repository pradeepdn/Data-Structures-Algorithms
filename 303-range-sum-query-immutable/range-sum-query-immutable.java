class NumArray {
    public int[] prefixSum;

    public NumArray(int[] nums) {
        if (nums.length == 0)
            return;
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return prefixSum[right];
        return prefixSum[right]-prefixSum[left-1] ;
    }
    /**Standard itirative */
    // public int[] num;

    // public NumArray(int[] nums) {
    //     num = nums;
    // }

    // public int sumRange(int left, int right) {
    //     int sum = 0;
    //     while (left <= right) {
    //         if (left == right) {
    //             sum = sum + num[left];
    //         } else {
    //             sum = sum + num[left] + num[right];
    //         }
    //         left++;
    //         right--;
    //     }
    //     return sum;
    // }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
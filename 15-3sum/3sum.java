class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

/* Use the two-pointer approach:
Iterate over the array with a for-loop using index i as the first element of the triplet.
Initialize two pointers: left = i + 1 and right = nums.length - 1.
While left < right:
Calculate sum = nums[i] + nums[left] + nums[right].
If sum == 0, add the triplet to the results list.
If sum < 0, move the left pointer to the right to increase the sum.
If sum > 0, move the right pointer to the left to decrease the sum.
Continue this until left meets right.
Repeat for each i in the array. */
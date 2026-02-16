class Solution {
    public int thirdMax(int[] nums) {
        // Use Long to avoid the Integer.MIN_VALUE edge case
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int n : nums) {
            // Skip if we've already seen this number (only unique counts)
            if (n == first || n == second || n == third) continue;

            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n > third) {
                third = n;
            }
        }

        // If third was never updated, return the max (first)
        // Otherwise, return third
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = { -1, -1 };
        if (nums == null || nums.length == 0)
            return result;

        result[0] = findBound(nums, target, true);
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}

// int[] result = { -1, -1 };
// int index = 0;
// int left = 0;
// int right = nums.length - 1;

// while (left <= right) {
//     int mid = left + (right - left) / 2;
//     if (nums[mid] == target) {
//         int start = mid;
//         while (start > 0 && nums[start - 1] == target) {
//             start--;
//         }
//         // Find the end
//         int end = mid;
//         while (end < nums.length - 1 && nums[end + 1] == target) {
//             end++;
//         }
//         return new int[] { start, end };
//     }
//     if (nums[mid] < target) {
//         left = mid + 1;
//     } else {
//         right = mid - 1;
//     }
// }
// return result;
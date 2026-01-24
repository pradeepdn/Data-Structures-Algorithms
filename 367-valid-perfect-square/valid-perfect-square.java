class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= num / mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return res * res == num;
    }
}
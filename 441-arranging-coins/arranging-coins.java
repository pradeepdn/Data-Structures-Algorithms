// class Solution {
//     public int arrangeCoins(int n) {
//         double x = (-1 + Math.sqrt(1 + 8.0 * n)) / 2;
//         return (int) x;
//     }
// }
class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long curr = mid * (mid + 1) / 2;

            if (curr == n) return (int) mid;

            if (n < curr) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}
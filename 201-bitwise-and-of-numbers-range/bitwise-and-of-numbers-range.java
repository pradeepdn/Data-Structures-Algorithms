class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        while (left >> 1 != right >> 1) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }
        return left << shift;
    }
}
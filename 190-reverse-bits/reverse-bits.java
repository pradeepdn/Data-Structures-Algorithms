class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n & 1);
            res = res | (bit << (31 - i));
            n >>>=1 ;
        }
        // for (int i = 31; i >= 0; i--) {
        //     res += (n % 2) * Math.pow(2, i);
        //     n = n / 2;
        // }
        return res;
    }
}
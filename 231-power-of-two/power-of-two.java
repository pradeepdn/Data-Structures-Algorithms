class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // Calculate log base 2: log10(n) / log10(2)
        double res = Math.log10(n) / Math.log10(2);
        return res % 1 == 0;
        // while (n % 2 == 0) {
        //     n /=2;
        // }
        // return n==1?true:false;
    }
}
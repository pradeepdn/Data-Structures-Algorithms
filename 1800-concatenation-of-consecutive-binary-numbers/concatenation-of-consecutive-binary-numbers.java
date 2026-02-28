class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int MOD = 1_000_000_007;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
            // If i is a power of 2, the binary representation 
            // needs one more bit (e.g., 2 is "10", 4 is "100")
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }
            
            // 1. Shift the current result left by the length of i
            // 2. Use bitwise OR to place i in the new space
            // 3. Apply modulo to keep the number manageable
            result = ((result << bitLength) | i) % MOD;
        }

        return (int) result;
    }
}
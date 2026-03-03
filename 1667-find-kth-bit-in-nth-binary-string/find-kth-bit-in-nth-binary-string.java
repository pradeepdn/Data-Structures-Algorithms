class Solution {
    public char findKthBit(int n, int k) {
        // Base case: S1 is always "0"
        if (n == 1) {
            return '0';
        }
        
        int length = (1 << n) - 1;
        int midpoint = length / 2 + 1;
        
        if (k == midpoint) {
            // The middle bit is always '1' for any Sn where n > 1
            return '1';
        } else if (k < midpoint) {
            // Left half is an exact copy of Sn-1
            return findKthBit(n - 1, k);
        } else {
            // Right half is reversed and inverted Sn-1
            // 1. Find the mirrored position in the left half
            int mirroredK = length - k + 1;
            // 2. Find the bit at that position in Sn-1
            char bit = findKthBit(n - 1, mirroredK);
            // 3. Invert it ('0' -> '1', '1' -> '0')
            return bit == '0' ? '1' : '0';
        }
    }
}
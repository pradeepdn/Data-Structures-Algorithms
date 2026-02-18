class Solution {
    public boolean hasAlternatingBits(int n) {
       /* Step 1: XOR the number with itself shifted by 1.
        If bits alternate, result 'x' will be all 1s (e.g., 1010 ^ 0101 = 1111)
        */
        int x = n ^ (n >> 1);
        
        /* Step 2: Check if x + 1 is a power of 2.
        If x is all 1s (1111), then x & (x + 1) will be 0 (1111 & 10000 = 0)
        */
        return (x & (x + 1)) == 0;
    }
}
class Solution:
    def concatenatedBinary(self, n: int) -> int:
        result = 0
        MOD = 10**9 + 7
        bit_length = 0
        
        for i in range(1, n + 1):
            # Check if i is a power of 2 (1, 2, 4, 8, 16...)
            # Every time we hit a power of 2, i needs one more bit to represent it
            if i & (i - 1) == 0:
                bit_length += 1
            
            # 1. Shift current result left by the number of bits in i
            # 2. Use bitwise OR (|) to append i to the end
            # 3. Take modulo to keep the number within 10^9 + 7
            result = ((result << bit_length) | i) % MOD
            
        return result
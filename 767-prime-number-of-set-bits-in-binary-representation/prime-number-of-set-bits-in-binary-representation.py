class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        # A bitmask where the 2nd, 3rd, 5th, 7th, 11th, 13th, 17th, and 19th bits are set
        # Binary: 10100010100010101100
        prime_mask = 665772
        count = 0
        
        for num in range(left, right + 1):
            # bin(num).count('1') is the Pythonic way to count set bits
            bits = bin(num).count('1')
            
            # Check if the 'bits'-th position in our mask is a 1
            if (prime_mask >> bits) & 1:
                count += 1
                
        return count
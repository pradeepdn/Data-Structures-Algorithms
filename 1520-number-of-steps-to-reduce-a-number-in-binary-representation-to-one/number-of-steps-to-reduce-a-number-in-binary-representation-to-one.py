class Solution:
    def numSteps(self, s: str) -> int:
        steps = 0
        carry = 0
        
        # Iterate from right to left, skipping the first character
        for i in range(len(s) - 1, 0, -1):
            bit = int(s[i])
            
            if bit + carry == 1:
                # Odd logic: Add 1 and Divide (2 steps)
                steps += 2
                carry = 1
            else:
                # Even logic: Just Divide (1 step)
                steps += 1
                # carry remains what it was (0 if 0+0, 1 if 1+1)
                
        return steps + carry
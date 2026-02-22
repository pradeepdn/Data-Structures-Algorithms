class Solution:
    def binaryGap(self, n: int) -> int:
        max_gap = 0
        last_position = -1
        
        while n > 0:
            # Get the position of the rightmost 1-bit
            # (n & -n) isolates the lowest set bit, e.g., 6 (110) -> 2 (010)
            lowbit = n & -n
            # .bit_length() tells us the position of that bit
            current_position = lowbit.bit_length() - 1
            
            if last_position != -1:
                max_gap = max(max_gap, current_position - last_position)
            
            last_position = current_position
            
            # Remove the bit we just processed
            n ^= lowbit 
            
        return max_gap
# class Solution:
#     def binaryGap(self, n: int) -> int:
#         max_gap = 0
#         last_position = -1
#         current_position = 0
        
#         while n > 0:
#             # Check if the rightmost bit is 1
#             if n & 1:
#                 if last_position != -1:
#                     # Update max_gap with the distance between current and last 1
#                     max_gap = max(max_gap, current_position - last_position)
                
#                 # Record the position of this 1
#                 last_position = current_position
            
#             # Shift right and move the 'tape measure' forward
#             n >>= 1
#             current_position += 1
            
#         return max_gap
class Solution:
    def sortByBits(self, arr: list[int]) -> list[int]:
        # Sort based on a tuple: (bit_count, original_value)
        # Python handles the tie-breaking automatically!
        arr.sort(key=lambda x: (bin(x).count('1'), x))
        return arr
class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        # We need to find 2^k unique substrings
        total_needed = 1 << k
        seen = set()

        # Slide the window across the string
        # s[i : i + k] takes a slice of length k
        for i in range(len(s) - k + 1):
            substring = s[i : i + k]
            if substring not in seen:
                seen.add(substring)
                # Optimization: Exit early if we found everything
                if len(seen) == total_needed:
                    return True
                    
        return False
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int totalNeeded = 1 << k; // This is 2^k
        boolean[] seen = new boolean[totalNeeded];
        int count = 0;
        
        // A mask to keep only the last k bits (e.g., if k=3, mask is 111 in binary)
        int mask = totalNeeded - 1;
        int currentRollingHash = 0;

        for (int i = 0; i < s.length(); i++) {
            // Push the new bit into the rolling hash
            currentRollingHash = ((currentRollingHash << 1) | (s.charAt(i) - '0')) & mask;

            // Once we have seen at least k bits, start tracking
            if (i >= k - 1) {
                if (!seen[currentRollingHash]) {
                    seen[currentRollingHash] = true;
                    count++;
                    // Optimization: If we found all codes, stop early
                    if (count == totalNeeded) return true;
                }
            }
        }

        return false;
    }
}
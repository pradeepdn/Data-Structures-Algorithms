class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int lastPosition = -1;
        int currentPosition = 0;

        while (n > 0) {
            // Step 1: Check if the current bit is a 1
            if ((n & 1) == 1) {
                // If this isn't the first '1' we've seen, calculate distance
                if (lastPosition != -1) {
                    maxGap = Math.max(maxGap, currentPosition - lastPosition);
                }
                // Update the last position to our current spot
                lastPosition = currentPosition;
            }
            
            // Step 2: Shift right to look at the next bit
            n >>= 1;
            
            // Step 3: Increment our position counter
            currentPosition++;
        }

        return maxGap;
    }
}
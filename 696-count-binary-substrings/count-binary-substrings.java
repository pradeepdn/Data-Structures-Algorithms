class Solution {
    public int countBinarySubstrings(String s) {
        int total = 0;
        int prevGroup = 0;
        int currentGroup = 1;

        for (int i = 1; i < s.length(); i++) {
            // If the character is the same, just increase the current group size
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentGroup++;
            } else {
                // Character changed! 
                // 1. Add the minimum of the two groups to our total
                total += Math.min(prevGroup, currentGroup);
                // 2. The old current group becomes the previous group
                prevGroup = currentGroup;
                // 3. Reset current group to 1 for the new character
                currentGroup = 1;
            }
        }

        // Final check for the last two groups after the loop ends
        return total + Math.min(prevGroup, currentGroup);
    }
}
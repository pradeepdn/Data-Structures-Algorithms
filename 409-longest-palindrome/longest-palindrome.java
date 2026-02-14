class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        int length = 0;
        for (int count : counts) {
            // This math trick adds only the even portion of the count
            // e.g., if count is 5, (5 / 2) * 2 = 4.
            length += (count / 2) * 2;
        }

        // If the total length is still smaller than the string, 
        // we have at least one odd character to put in the middle.
        if (length < s.length()) {
            length += 1;
        }

        return length;
    }
}
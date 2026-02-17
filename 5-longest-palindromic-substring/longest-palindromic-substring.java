public class Solution {
    public String longestPalindrome(String s) {
        // Edge case: if string is empty, return empty
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length (center is i)
            int len1 = expandFromMiddle(s, i, i);
            
            // Case 2: Even length (center is between i and i+1)
            int len2 = expandFromMiddle(s, i, i + 1);
            
            // Take the maximum of the two expansion types
            int maxLength = Math.max(len1, len2);

            // If we found a longer palindrome than our previous best
            if (maxLength > (end - start)) {
                // Update start and end pointers 
                // Formula: move half the length left and half the length right
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        // Return the final substring using our best pointers
        return s.substring(start, end + 1);
    }

    // Helper method to expand outwards
    private int expandFromMiddle(String s, int left, int right) {
        // While indices are in bounds AND characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;  // move left pointer further left
            right++; // move right pointer further right
        }
        
        // Return the length of the palindrome found
        // (right - left - 1) because the loop stops AFTER pointers go too far
        return right - left - 1;
    }
}
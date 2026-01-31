import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to Set for O(1) lookup speed
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: empty string
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If the prefix s[0...j] is valid AND s[j...i] is in the dict
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Found a way to make this prefix, move to next i
                }
            }
        }

        return dp[s.length()];
    }
}
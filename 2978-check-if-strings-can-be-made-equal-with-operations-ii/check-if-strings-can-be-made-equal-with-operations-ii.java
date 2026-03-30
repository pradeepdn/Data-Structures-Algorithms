class Solution {
    public boolean checkStrings(String s1, String s2) {
        // Frequency arrays for characters at even and odd indices
        int[] evenFreq = new int[26];
        int[] oddFreq = new int[26];
        
        int n = s1.length();
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Increment for s1, decrement for s2 at even indices
                evenFreq[s1.charAt(i) - 'a']++;
                evenFreq[s2.charAt(i) - 'a']--;
            } else {
                // Increment for s1, decrement for s2 at odd indices
                oddFreq[s1.charAt(i) - 'a']++;
                oddFreq[s2.charAt(i) - 'a']--;
            }
        }
        
        // If all counts are zero, the groups are identical
        for (int i = 0; i < 26; i++) {
            if (evenFreq[i] != 0 || oddFreq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;
        char[] res = new char[len];
        boolean[] fixed = new boolean[len];

        // Fill with '?' to denote unfixed slots
        for (int i = 0; i < len; i++) res[i] = '?';

        // Pass 1: Mandatory Fill for 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int idx = i + j;
                    if (res[idx] != '?' && res[idx] != str2.charAt(j)) {
                        return ""; // Contradiction: Two 'T's want different chars
                    }
                    res[idx] = str2.charAt(j);
                    fixed[idx] = true;
                }
            }
        }

        // Pass 2: Fill remaining slots with 'a' (temporarily)
        for (int i = 0; i < len; i++) {
            if (res[i] == '?') res[i] = 'a';
        }

        // Pass 3: Fix 'F' violations
        // If a window starting at i matches str2 but is marked 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (isMatch(res, i, str2)) {
                    // Find the rightmost character in this window that is NOT fixed
                    int changeIdx = -1;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!fixed[i + j]) {
                            changeIdx = i + j;
                            break;
                        }
                    }

                    // If no character can be changed, it's impossible
                    if (changeIdx == -1) return "";

                    // Change the character to something else. 
                    // To be lexicographically smallest, try 'a' if it's not 'a', otherwise 'b'.
                    // Since it currently matches str2, we just need it to NOT match str2.
                    // If str2[j] is 'a', we must use 'b'. If str2[j] is not 'a', use 'a'.
                    char targetChar = (str2.charAt(changeIdx - i) == 'a') ? 'b' : 'a';
                    res[changeIdx] = targetChar;
                    // Note: We don't mark it 'fixed' yet because a later 'F' might 
                    // require another change, though typically we process left-to-right.
                }
            }
        }

        // Pass 4: Final Validation
        // Ensure our 'F' fixes didn't break any 'T's or create new 'F' violations
        for (int i = 0; i < n; i++) {
            boolean match = isMatch(res, i, str2);
            if (str1.charAt(i) == 'T' && !match) return "";
            if (str1.charAt(i) == 'F' && match) return "";
        }

        return new String(res);
    }

    private boolean isMatch(char[] res, int start, String str2) {
        for (int j = 0; j < str2.length(); j++) {
            if (res[start + j] != str2.charAt(j)) return false;
        }
        return true;
    }
}
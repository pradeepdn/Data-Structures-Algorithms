import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, i = 0;
        List<String> results = new ArrayList<>();

        for (int j = 0; j < s.length(); ++j) {
            // Count balance: +1 for '1', -1 for '0'
            if (s.charAt(j) == '1') count++;
            else count--;

            // When count hits 0, we found an indivisible special substring
            if (count == 0) {
                // 1. Strip the outer 1 and 0: s.substring(i + 1, j)
                // 2. Recurse on the inside
                // 3. Put the 1 and 0 back around the result
                results.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }

        // Sort substrings descending to get the lexicographically largest result
        Collections.sort(results, Collections.reverseOrder());
        
        return String.join("", results);
    }
}
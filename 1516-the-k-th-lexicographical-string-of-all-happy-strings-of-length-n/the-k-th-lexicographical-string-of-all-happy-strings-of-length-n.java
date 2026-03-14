class Solution {
    public String getHappyString(int n, int k) {
        // 1. Calculate the total number of happy strings: 3 * 2^(n-1)
        int total = 3 * (int) Math.pow(2, n - 1);
        // If k is out of bounds, return an empty string
        if (k > total)
            return "";
        StringBuilder result = new StringBuilder();
        char[] letters = { 'a', 'b', 'c' };
        // 2. Adjust k to be 0-indexed for easier division math
        k--;
        // 3. Determine the first character
        // Each starting letter (a, b, c) covers (total / 3) strings
        int weight = total / 3;
        int firstCharIndex = k / weight;
        result.append(letters[firstCharIndex]);
        // Update k to its relative position within the chosen branch
        k %= weight;
        // 4. Determine the remaining n-1 characters
        for (int i = 1; i < n; i++) {
            // Each subsequent choice covers 2^(remaining_slots)
            weight /= 2;

            // Get the last character added to avoid repeating it
            char lastChar = result.charAt(result.length() - 1);

            // Get the two available letters (excluding lastChar)
            char[] options = getOptions(lastChar);

            // Jump logic: pick the 0th or 1st option based on current k
            int nextCharIndex = k / weight;
            result.append(options[nextCharIndex]);

            // Update k for the next level
            k %= weight;
        }

        return result.toString();
    }

    private char[] getOptions(char lastChar) {
        if (lastChar == 'a')
            return new char[] { 'b', 'c' };
        if (lastChar == 'b')
            return new char[] { 'a', 'c' };
        return new char[] { 'a', 'b' };
    }
}
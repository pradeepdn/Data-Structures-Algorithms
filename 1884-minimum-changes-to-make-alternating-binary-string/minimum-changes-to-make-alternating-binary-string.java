class Solution {
    public int minOperations(String s) {
        int change = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != i % 2) {
                change++;
            }
        }

        return Math.min(change, s.length() - change);
    }
}
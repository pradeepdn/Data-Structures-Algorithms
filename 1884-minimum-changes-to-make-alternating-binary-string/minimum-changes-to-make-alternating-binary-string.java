class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int change = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' != i % 2) {
                change++;
            }
        }

        return Math.min(change, n - change);
    }
}
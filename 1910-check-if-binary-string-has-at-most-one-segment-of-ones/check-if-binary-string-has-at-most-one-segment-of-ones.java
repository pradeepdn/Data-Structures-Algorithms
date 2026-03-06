class Solution {
    public boolean checkOnesSegment(String s) {
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) - '0' == 0) {
                i++;
                if (i < s.length() && s.charAt(i) - '0' == 1) {
                    return false;
                }
            }
            i++;
        }
        return true;

    }
}
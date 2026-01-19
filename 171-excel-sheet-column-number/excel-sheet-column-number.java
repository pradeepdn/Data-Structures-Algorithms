class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()){
            result *= 26;
            int val = c - 'A' + 1;
            result += val;
        }
        return result;
    }
}
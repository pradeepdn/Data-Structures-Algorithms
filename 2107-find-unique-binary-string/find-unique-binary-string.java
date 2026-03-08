class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
            // Get the i-th character of the i-th string
            char currentChar = nums[i].charAt(i);
            
            // Append the opposite character to our result
            sb.append(currentChar == '0' ? '1' : '0');
        }
        
        return sb.toString();
    }
}
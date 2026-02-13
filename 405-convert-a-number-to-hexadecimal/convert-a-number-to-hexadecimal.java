class Solution {
    public String  toHex(int num) {
        if (num == 0) return "0";
        
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder result = new StringBuilder();
        
        // We use a counter or check for num != 0
        // In Java, the >>> operator is the "unsigned right shift"
        while (num != 0 && result.length() < 8) {
            // 1. Get the last 4 bits using a bitmask (15 is 1111 in binary)
            int lastFourBits = num & 15; 
            
            // 2. Map those bits to a hex character and prepend
            result.append(hexChars[lastFourBits]);
            
            // 3. Unsigned shift right by 4 bits
            num >>>= 4;
        }
        
        // Since we appended, we need to reverse the string
        return result.reverse().toString();
    }
}
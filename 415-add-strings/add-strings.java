class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1; // Pointer for the end of num1
        int j = num2.length() - 1; // Pointer for the end of num2
        int carry = 0;

        // Loop as long as there are digits to process or a carry remains
        while (i >= 0 || j >= 0 || carry != 0) {
            // Convert char to int by subtracting '0'
            // If pointer is out of bounds, use 0
            int d1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = d1 + d2 + carry;
            res.append(sum % 10); // Append the single digit
            carry = sum / 10;     // Calculate new carry (either 0 or 1)

            i--;
            j--;
        }

        // Since we added from right to left, the result is backwards
        return res.reverse().toString();
    }
}
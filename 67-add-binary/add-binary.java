import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1; // Pointer for string a
        int j = b.length() - 1; // Pointer for string b
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; // Start with the carry from the previous step

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char '0' or '1' to int
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // If sum is 2 (1+1), digit is 0 and carry is 1
            // If sum is 3 (1+1+1), digit is 1 and carry is 1
            result.append(sum % 2);
            carry = sum / 2;
        }

        // Since we appended from right to left, we must reverse it
        return result.reverse().toString();

        // BigInteger b1 = new BigInteger(a, 2);
        // BigInteger b2 = new BigInteger(b, 2);

        // BigInteger result = b1.add(b2);

        // return result.toString(2);
    }
}
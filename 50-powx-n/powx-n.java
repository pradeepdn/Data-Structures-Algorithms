class Solution {
    public double myPow(double x, int n) {
        long exp = n;               // copy exponent into a long to avoid overflow when n = Integer.MIN_VALUE
        if (exp < 0) {              // if original exponent is negative, we'll invert the base and make exponent positive
            x = 1.0 / x;            // invert base: x -> 1/x
            exp = -exp;             // make exponent positive (safe because exp is long)
        }

        double result = 1.0;        // accumulator for the final answer

        // Loop until we've processed all bits of exp (binary exponentiation)
        while (exp > 0) {
            if ((exp & 1) == 1) {   // if the current least-significant bit of exp is 1 (i.e., exp is odd)
                result *= x;        // incorporate the current base x into the result
            }
            x *= x;                 // square the base (move to next bit: x, x^2, x^4, x^8, ...)
            exp >>= 1;              // shift exp right by 1 bit (divide exp by 2, discarding remainder)
        }

        return result;             // final result = original x raised to original n
    }
}

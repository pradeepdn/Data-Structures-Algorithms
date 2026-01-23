class Solution {
    public boolean isPowerOfThree(int n) {
        return (n>0 && 1162261467 % n == 0);
    }
}
/**To put it simply:
3 is Prime: Because 3 is prime, any power of 3 (like 9 or 27) can only be divided by 3 or smaller powers of 3.
The "Boss" Number: $3^{19}$ ($1,162,261,467$) is the largest power of 3 that fits in a standard integer. It is basically a giant box filled only with "3s."
The Test: If you have a number $n$ and it divides into that "Boss" number perfectly ($1162261467 \text{ % } n == 0$), then $n$ must be made of only 3s. */
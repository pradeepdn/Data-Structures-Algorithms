class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double guess = x / 2.0;

        for (int i = 0; i < 100; i++) {
            guess = (guess + x / guess) / 2.0;
        }

        return (int)guess;
    }
}

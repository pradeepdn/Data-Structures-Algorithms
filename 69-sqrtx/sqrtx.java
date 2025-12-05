class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double guess = x / 2.0;

        while (Math.abs(guess*guess - x) > 1e-6){
            guess = (guess + x / guess) / 2.0;
        }

        return (int)guess;
    }
}

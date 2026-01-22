class Solution {
    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        long sum = 0; 
        for (int i = 0; i < flips.length; i++) {
            sum += flips[i];
            
            long k = i + 1;
            long n = (k * (k + 1)) / 2;

            if (n == sum)
                count++;
        }
        return count;
    }
}
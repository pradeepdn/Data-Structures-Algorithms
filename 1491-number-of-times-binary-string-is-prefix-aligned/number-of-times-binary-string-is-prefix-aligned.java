class Solution {
    public int numTimesAllBlue(int[] flips) {

        /** Max Value approach */
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < flips.length; i++) {
            
            max = Math.max(max, flips[i]);
            if (i+1 >= max) {
                count++;
            }
            
        }
        /**Gaussian Sum*/
        // int count = 0;
        // long sum = 0;
        // for (int i = 0; i < flips.length; i++) {
        //     sum += flips[i];

        //     long k = i + 1;
        //     long n = (k * (k + 1)) / 2;

        //     if (n == sum)
        //         count++;
        // }
        return count;
    }
}
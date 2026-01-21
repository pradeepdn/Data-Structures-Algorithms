class Solution {
    public int addDigits(int num) {
        /**Optimal*/
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
        /** shortest */
        //return 1 + (num - 1) % 9;
        /** own */
        // while (num > 9) {
        //     int sum = 0;
        //     while (num != 0) {
        //         sum += num % 10;
        //         num = num / 10;
        //     }
        //     num = sum;
        // }
        // return num;
    }
}
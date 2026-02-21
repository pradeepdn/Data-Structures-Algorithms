class Solution {
    public int countPrimeSetBits(int left, int right) {
        // This mask has 1s at positions 2, 3, 5, 7, 11, 13, 17, 19
        // Binary: 010100010100010101100 (Decimal: 665772)
        int primeMask = 665772;
        int count = 0;

        for (int i = left; i <= right; i++) {
            // Integer.bitCount is a highly optimized hardware-level function
            int bits = Integer.bitCount(i);
            
            // Check if the bit at position 'bits' is a 1 in our mask
            if (((primeMask >> bits) & 1) == 1) {
                count++;
            }
        }

        return count;
    }
}
// class Solution {
//     public int countPrimeSetBits(int left, int right) {

//         HashSet<Integer> prime = new HashSet<Integer>();
//         prime.add(2);
//         prime.add(3);
//         prime.add(5);
//         prime.add(7);
//         prime.add(11);
//         prime.add(13);
//         prime.add(17);
//         prime.add(19);

//         int count = 0;
//         while (left <= right) {
//             int i = left;
//             int bits = 0;
//             while (i > 0) {
//                 if (i % 2 == 1) {
//                     bits++;
//                 }
//                 i = i / 2;
//             }
//             if (prime.contains(bits)) {
//                 count++;
//             }
//             left++;
//         }
//         return count;
//     }
// }
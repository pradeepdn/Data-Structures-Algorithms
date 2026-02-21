class Solution {
    public int countPrimeSetBits(int left, int right) {

        HashSet<Integer> prime = new HashSet<Integer>();
        prime.add(2);
        prime.add(3);
        prime.add(5);
        prime.add(7);
        prime.add(11);
        prime.add(13);
        prime.add(17);
        prime.add(19);

        int count = 0;
        while (left <= right) {
            int i = left;
            int bits = 0;
            while (i > 0) {
                if (i % 2 == 1) {
                    bits++;
                }
                i = i / 2;
            }
            if (prime.contains(bits)) {
                count++;
            }
            left++;
        }
        return count;
    }
}
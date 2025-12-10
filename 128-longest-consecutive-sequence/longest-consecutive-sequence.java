class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seq = new HashSet<>();
        int maxSeq = 0;

        for (int i = 0; i < nums.length; i++) {
            seq.add(nums[i]);
        }

        for (int num : seq) {
            int seqLen = 0;
            if (!seq.contains(num - 1)) {
                seqLen++;
                while (seq.contains(num + seqLen)) {
                    seqLen++;
                }
            }
            maxSeq = Math.max(maxSeq, seqLen);
        }
        return maxSeq;
    }
}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] temp = new int[nums1.length];
        int k = 0; // This tracks the actual size of the intersection

        for (int num : nums2) {
            // If the number is in the map and has a count > 0
            if (map.containsKey(num) && map.get(num) > 0) {
                temp[k++] = num; // Add to result and increment counter
                map.put(num, map.get(num) - 1); // "Use up" one instance
            }
        }

        // Step 3: Trim the array to the exact size of k
        return Arrays.copyOf(temp, k);
    }
}
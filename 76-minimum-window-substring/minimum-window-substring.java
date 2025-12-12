class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> charOft = new HashMap<>();
        Map<Character, Integer> curr = new HashMap<>();

        int left = 0;

        for (int i = 0; i < t.length(); i++) {
            charOft.put(t.charAt(i), charOft.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            curr.put(s.charAt(right), curr.getOrDefault(s.charAt(right), 0) + 1);
            String cur = s.substring(left, right + 1);
            while (containsAll(curr, charOft)) {
                if (result.isEmpty() || cur.length() < result.length()) {
                    result = cur;
                }
                int count = curr.get(s.charAt(left));
                if (count == 1) {
                    curr.remove(s.charAt(left)); // remove the key entirely
                } else {
                    curr.put(s.charAt(left), curr.get(s.charAt(left)) - 1); // decrement the value
                }
                left++;
                cur = s.substring(left, right + 1);
            }

        }
        return result;
    }

    boolean containsAll(Map<Character, Integer> curr, Map<Character, Integer> tFreq) {
        for (Character c : tFreq.keySet()) {
            if (curr.getOrDefault(c, 0) < tFreq.get(c)) {
                return false;
            }
        }
        return true;
    }
}
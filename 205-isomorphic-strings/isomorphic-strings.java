class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = s.charAt(i);
            char w = t.charAt(i);

            if (s2t.containsKey(c)) {
                if (!s2t.get(c).equals(w)) {
                    return false;
                }
            }
            if (t2s.containsKey(w))
                if (t2s.get(w) != c) {
                    return false;
                }
            s2t.put(c, w);
            t2s.put(w, c);
        }
        return true;       
    }
}
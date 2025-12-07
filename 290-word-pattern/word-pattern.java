class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        Map<Character, String> Pattern = new HashMap<>();
        //System.out.println(pattern.charAt(0));
        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (Pattern.containsKey(c)) {
                if (!Pattern.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (Pattern.containsValue(words[i])) {
                    return false;
                }
            }
            Pattern.put(c, words[i]);
        }

        return true;
    }
}
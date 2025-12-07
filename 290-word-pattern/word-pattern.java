/* Fastest with two maps */
class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        Map<Character, String> c2w = new HashMap<>();
        Map<String, Character> w2c = new HashMap<>();

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (c2w.containsKey(c)) {
                if (!c2w.get(c).equals(w)) {
                    return false;
                }
            }
            if (w2c.containsKey(w))
                if (w2c.get(w) != c) {
                    return false;
                }
            c2w.put(c, w);
            w2c.put(w, c);
        }
        return true;
    }
}
/* My first solution */

// class Solution {
//     public boolean wordPattern(String pattern, String s) {
//         String[] words = s.split(" ");
//         Map<Character, String> Pattern = new HashMap<>();
//         if (words.length != pattern.length()) {
//             return false;
//         }
//         for (int i = 0; i < words.length; i++) {
//             char c = pattern.charAt(i);
//             if (Pattern.containsKey(c)) {
//                 if (!Pattern.get(c).equals(words[i])) {
//                     return false;
//                 }
//             } else {
//                 if (Pattern.containsValue(words[i])) {
//                     return false;
//                 }
//             }
//             Pattern.put(c, words[i]);
//         }
//         return true;
//     }
// }
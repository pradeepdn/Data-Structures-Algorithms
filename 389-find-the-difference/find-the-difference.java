// Using Hash Map
// class Solution {
//     public char findTheDifference(String s, String t) {

//         Map<Character, Integer> map = new HashMap<>();

//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         for (char c : t.toCharArray()) {
//             if (!map.containsKey(c) || map.get(c) == 0) {
//                 return c;
//             } else {
//                 map.put(c, map.get(c) - 1);
//             }
//         }
//         return 'c';
//     }
// }

// Using array

// class Solution {
//     public char findTheDifference(String s, String t) {
//         int[] counts = new int[26];

//         for (int i = 0; i < s.length(); i++) {
//             counts[s.charAt(i) - 'a']++;
//         }

//         for (int i = 0; i < t.length(); i++) {
//             char c = t.charAt(i);
//             if (--counts[c - 'a'] < 0) {
//                 return c;
//             }
//         }
//         return ' ';
//     }
// }

// Fastest practicaly

class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        // XOR every character in both strings
        for (int i = 0; i < s.length(); i++)
            res ^= s.charAt(i);
        for (int i = 0; i < t.length(); i++)
            res ^= t.charAt(i);
        return res;
    }
}
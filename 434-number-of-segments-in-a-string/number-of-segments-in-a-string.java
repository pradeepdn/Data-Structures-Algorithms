class Solution {
    public int countSegments(String s) {
        if ( s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                count++;
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
            }else if (s.charAt(i) == ' ') {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
            }
        }
        return count;
    }
}

// class Solution {
//     public int countSegments(String s) {
//         int count = 0;
//         for (int i = 0; i < s.length(); i++) {
//             // A segment starts if the current char is not a space 
//             // AND (it's the first char OR the previous char was a space)
//             if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }
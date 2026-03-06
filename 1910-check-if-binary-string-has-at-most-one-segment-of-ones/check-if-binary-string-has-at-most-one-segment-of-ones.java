// class Solution {
//     public boolean checkOnesSegment(String s) {
//         int i = 0;
//         while (i < s.length()) {
//             while (i < s.length() && s.charAt(i) - '0' == 0) {
//                 i++;
//                 if (i < s.length() && s.charAt(i) - '0' == 1) {
//                     return false;
//                 }
//             }
//             i++;
//         }
//         return true;

//     }
// }
class Solution {
    public boolean checkOnesSegment(String s) {
        for (int i = 1; i < s.length(); i++) {
            // We found a '1' that follows a '0'
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false;
            }
        }
        return true;
    }
}
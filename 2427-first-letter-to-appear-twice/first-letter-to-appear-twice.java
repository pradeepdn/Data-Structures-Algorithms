class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> check = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!check.add(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return 'l';
    }
}
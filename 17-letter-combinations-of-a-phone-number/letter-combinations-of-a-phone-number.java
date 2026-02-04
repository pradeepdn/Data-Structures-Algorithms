class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();
        HashMap<String, List<String>> letterCombo = new HashMap<>();
        letterCombo.put("2", List.of("a", "b", "c"));
        letterCombo.put("3", List.of("d", "e", "f"));
        letterCombo.put("4", List.of("g", "h", "i"));
        letterCombo.put("5", List.of("j", "k", "l"));
        letterCombo.put("6", List.of("m", "n", "o"));
        letterCombo.put("7", List.of("p", "q", "r", "s"));
        letterCombo.put("8", List.of("t", "u", "v"));
        letterCombo.put("9", List.of("w", "x", "y", "z"));

        List<String> result = new ArrayList<>();
        backtrack(result, digits, "", 0, letterCombo);
        return result;
    }

    private void backtrack(List<String> result, String digits, String current, int index,
            Map<String, List<String>> map) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String digit = String.valueOf(digits.charAt(index));
        for (String letter : map.get(digit)) {
            backtrack(result, digits, current + letter, index + 1, map);
        }
    }
}
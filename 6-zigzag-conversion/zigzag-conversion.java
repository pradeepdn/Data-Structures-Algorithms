class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() == 1)
            return s;
        Map<Integer, StringBuilder> rows = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            rows.put(i, new StringBuilder());
        }

        int row = 0;
        int dir = 1;

        for (char c : s.toCharArray()) {

            rows.get(row).append(c);

            if (row == 0)
                dir = 1;
            else if (row == numRows - 1)
                dir = -1;

            row += dir;

        }

        StringBuilder results = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            results.append(rows.get(i));
        }
        return results.toString();
    }
}
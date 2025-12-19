class Solution {
    public int calculate(String s) {
        Deque<Integer> cal = new ArrayDeque<>();
        int result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                result += sign * num;
                i--;
                continue;
            }
            if (c == '+') {
                sign = +1;
            }
            if (c == '-') {
                sign = -1;
            }
            if (c == '(') {
                cal.push(result);
                cal.push(sign);
                result = 0;
                sign = 1;
            }
            if (c == ')') {
                int prevSign = cal.pop();
                int prevRes = cal.pop();
                result = prevRes + prevSign * result;
            }
        }
        return result;
    }
}
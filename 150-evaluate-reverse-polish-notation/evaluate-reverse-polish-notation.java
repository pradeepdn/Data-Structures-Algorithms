class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> rpn = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int b = rpn.pop();
                int a = rpn.pop();
                rpn.push(a + b);
            } else if (tokens[i].equals("-")) {
                int b = rpn.pop();
                int a = rpn.pop();
                rpn.push(a - b);
            } else if (tokens[i].equals("*")) {
                int b = rpn.pop();
                int a = rpn.pop();
                rpn.push(a * b);
            } else if (tokens[i].equals("/")) {
                int b = rpn.pop();
                int a = rpn.pop();
                rpn.push(a / b);
            } else {
                rpn.push(Integer.parseInt(tokens[i]));
            }
        }
        return rpn.pop();
    }
}
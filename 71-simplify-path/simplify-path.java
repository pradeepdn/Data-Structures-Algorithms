class Solution {
    public String simplifyPath(String path) {

        Deque<String> st = new ArrayDeque<>();
        String res = "";
        res += "/";

        for (int i = 0; i < path.length(); i++) {

            String dir = "";
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }
            while (i < path.length() && path.charAt(i) != '/') {
                dir += path.charAt(i);
                i++;
            }
            if (dir.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (dir.equals(".")) {
                continue;
            } else if (dir.length() != 0) {
                st.push(dir);
            }
        }

        Deque<String> st1 = new ArrayDeque<>();

        while (!st.isEmpty()) {
            st1.push(st.pop());
        }
        while (!st1.isEmpty()) {
            if (st1.size() != 1) {
                res += (st1.pop() + "/");
            } else {
                res += st1.pop();
            }
        }

        return res;
    }
}
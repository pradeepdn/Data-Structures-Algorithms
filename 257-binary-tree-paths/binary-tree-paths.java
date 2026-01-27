/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) {
            BTpaths(root, new StringBuilder(), answer);
        }
        return answer;
    }

    public void BTpaths(TreeNode root, StringBuilder s, List<String> answer) {
        int len = s.length();
        s.append(root.val);
        if (root.left == null && root.right == null) {
            answer.add(s.toString());

        } else {
            s.append("->");

            if (root.left != null) {
                BTpaths(root.left, s, answer);
            }
            if (root.right != null) {
                BTpaths(root.right, s, answer);
            }
        }
        s.setLength(len);
    }

}
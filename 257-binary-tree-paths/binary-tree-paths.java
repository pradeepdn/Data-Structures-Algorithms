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
            BTpaths(root, "", answer);
        }
        return answer;
    }

    public void BTpaths(TreeNode root, String s, List<String> answer) {
        s = s + root.val;
        if (root.left == null && root.right == null) {
            answer.add(s);
            return;
        } else {
            s = s + "->";
        }
        if (root.left != null) {
            BTpaths(root.left, s, answer);
        }
        if (root.right != null) {
            BTpaths(root.right, s, answer);
        }
    }

}
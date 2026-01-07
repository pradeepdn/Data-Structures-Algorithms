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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        get_gain(root);
        return max;
    }

    private int get_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left_gain = Math.max(get_gain(node.left), 0);
        int right_gain = Math.max(get_gain(node.right), 0);

        int current_path_sum = node.val + left_gain + right_gain;

        max = Math.max(max, current_path_sum);

        return node.val + Math.max(left_gain, right_gain);
    }
}
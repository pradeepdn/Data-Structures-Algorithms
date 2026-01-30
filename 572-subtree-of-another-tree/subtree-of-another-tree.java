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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String tree = serialize(root);
        String subTree = serialize(subRoot);

        return tree.contains(subTree);
    }

    public String serialize(TreeNode node){
        if(node == null){
            return ",#";
        }
        String left = serialize(node.left);
        String right = serialize(node.right);

        return ","+node.val+left+right;
    }
}
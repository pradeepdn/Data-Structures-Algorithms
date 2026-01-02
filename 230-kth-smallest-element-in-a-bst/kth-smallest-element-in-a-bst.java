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
    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        trav(root,k);
        return result;
    }

    private void trav(TreeNode node, int x) {
        if (node == null) {
            return;
        }
        trav(node.left, x);
        count++;
        if(count == x){
            result = node.val;
            return;
        }        
        if(count <= x){
            trav(node.right, x);
        }
        
    }
}
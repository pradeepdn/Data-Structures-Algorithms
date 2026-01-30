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
    int totalTilt = 0;
    public int findTilt(TreeNode root) {
       tiltSum(root);
       return totalTilt; 
       
    }
    public int tiltSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftTilt = tiltSum(root.left);
        int rightTilt = tiltSum(root.right);

        totalTilt += Math.abs(leftTilt - rightTilt);
        return root.val + leftTilt + rightTilt;
    }
}
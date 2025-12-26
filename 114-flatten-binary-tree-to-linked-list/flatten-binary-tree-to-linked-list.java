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

    Queue<TreeNode> preOrder = new LinkedList<>();

    public void flatten(TreeNode root) {
        preOrder(root);

        TreeNode curr = preOrder.poll();

        while(!preOrder.isEmpty()){
            TreeNode nextNode = preOrder.poll();
            curr.left = null;
            curr.right = nextNode;
            curr = nextNode;
        }
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder.add(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    // public void flatten(TreeNode root) {
    //     TreeNode curr = root;
    //     while (curr != null) {
    //         if (curr.left != null) {
    //             TreeNode prev = curr.left;
    //             while (prev.right != null) {
    //                 prev = prev.right;
    //             }
    //             prev.right = curr.right;
    //             curr.right = curr.left;
    //             curr.left = null;

    //         }
    //         curr = curr.right;
    //     }
    // }
}

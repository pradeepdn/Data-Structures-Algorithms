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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levOrder = new ArrayList<>();
        traversal(root, 0, levOrder);
        return levOrder;
    }

    private void traversal(TreeNode node, int level, List<List<Integer>> levOrd) {
        if (node == null)
            return;
        if (level == levOrd.size()) {
            levOrd.add(new LinkedList<>());
        }
        List<Integer> currentLevel = levOrd.get(level);
        if (level % 2 == 0) {
            currentLevel.add(node.val);
        } else if (level % 2 != 0) {
            currentLevel.add(0, node.val);
        }
        traversal(node.left, level + 1, levOrd);
        traversal(node.right, level + 1, levOrd);

    }
}
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
class Homework4_2 {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int parentVal) {
        if (root == null)
            return parentVal;
        root.val += dfs(root.right, parentVal);
        return dfs(root.left, root.val);
    }
}
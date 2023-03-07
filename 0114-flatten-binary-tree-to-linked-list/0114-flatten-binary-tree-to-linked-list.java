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
    public void flatten(TreeNode root) {
        dfs(root,null);
    }
    public TreeNode dfs(TreeNode root, TreeNode pre){
        if(root == null)
            return pre;
        TreeNode right =  dfs(root.right,pre);
        TreeNode left =  dfs(root.left,right);
        root.right = left;
        root.left = null;
        return root;
    }
}
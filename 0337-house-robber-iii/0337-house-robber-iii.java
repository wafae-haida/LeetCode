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
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }
    public int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0,0};
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
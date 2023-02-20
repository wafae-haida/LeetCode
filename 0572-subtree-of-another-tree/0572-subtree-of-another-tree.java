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
        if(subRoot==null && root==null)
            return true;
        if(subRoot==null || root==null)
            return false;
        if(isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot))
            return true;
        return isItSame(root,subRoot);
    }
    public boolean isItSame(TreeNode root, TreeNode subRoot){
        if(subRoot==null && root==null)
            return true;
        if(subRoot==null || root==null)
            return false;
        if(subRoot.val!=root.val)
            return false;
        return isItSame(root.left,subRoot.left) && isItSame(root.right,subRoot.right);
    }
}
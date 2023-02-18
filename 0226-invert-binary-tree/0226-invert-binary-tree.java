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
/*
Understanding:
    1->2->4
    |  |
    |  8
    |
    5->5
    |
    5
        result:root=1
    Questions:
        What do you mean by invert?left side became right side.
        What is the range of the node number?[0,100]
        What is the range of its values?[-100,100]
Target:
    return the root of the giving tree
Solution:

*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        reverseSides(root);
       return root;
    }
    public void reverseSides(TreeNode root){
        if(root==null)
            return;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        reverseSides(root.left);
        reverseSides(root.right);
    }
}
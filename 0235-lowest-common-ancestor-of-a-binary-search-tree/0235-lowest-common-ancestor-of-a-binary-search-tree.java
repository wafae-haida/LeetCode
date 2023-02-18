/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Understanding:
    Unique values
    left.val<root.val<right.val
    each node has two nodes
    Question:
    what is the range of the nodes? start at 2
        Range of thier values?we have negative and positive values
Target:
return the LCA it is a TreeNode (the minimum parent the node can be the parent of itself)
Solution:
    rescursion
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(p.val>root.val && q.val>root.val)
           return lowestCommonAncestor(root.right,p,q);
        if(p.val<root.val && q.val<root.val)
           return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        postorder(root, output);
        return output;
    }
    
    public void postorder(TreeNode root,List<Integer> output){
        if(root == null){
            return;
        }
        postorder(root.left, output);
        postorder(root.right, output);
        output.add(root.val);
    }
}
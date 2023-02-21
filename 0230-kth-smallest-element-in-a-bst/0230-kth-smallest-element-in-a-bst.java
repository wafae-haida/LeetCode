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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans=new ArrayList<>();
        trTreeToList(root,ans);
        return ans.get(k-1);//0-indexes
    }
    public void trTreeToList(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        trTreeToList(root.left,list);
        list.add(root.val);
        trTreeToList(root.right,list);
    }
}
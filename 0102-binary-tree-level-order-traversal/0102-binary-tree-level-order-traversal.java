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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> heap=new LinkedList<>();//where i will store the root
        heap.add(root);
        while(!heap.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int len=heap.size();
            for(int i=0;i<len;i++){
                TreeNode tmp=heap.poll();
                level.add(tmp.val);
                if(tmp.left!=null)
                    heap.add(tmp.left);
                if(tmp.right!=null)
                    heap.add(tmp.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
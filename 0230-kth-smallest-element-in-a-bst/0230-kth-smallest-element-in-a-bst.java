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
        Queue<Integer> minHeap=new PriorityQueue<>();
        trTreeToList(root,minHeap);
        int ans=0;
        while(k>0){
            ans=minHeap.poll();
            k--;
        }
        return ans;
    }
    public void trTreeToList(TreeNode root, Queue<Integer> minHeap){
        if(root==null)
            return;
        minHeap.add(root.val);
        trTreeToList(root.left,minHeap);
        trTreeToList(root.right,minHeap);
    }
}
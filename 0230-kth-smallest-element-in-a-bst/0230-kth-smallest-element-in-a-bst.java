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
    Queue<Integer> maxheap;
    public int kthSmallest(TreeNode root, int k) {
        maxheap = new PriorityQueue<>((a,b)->b-a);
        traverse(root,k);
        return maxheap.peek()==null?0:maxheap.poll();
    }
    public void traverse(TreeNode root, int k){
      if(root == null)
        return;
      maxheap.offer(root.val);
      if(maxheap.size() > k)
        maxheap.poll();
      traverse(root.right,k);
      traverse(root.left, k);
    }
}

    
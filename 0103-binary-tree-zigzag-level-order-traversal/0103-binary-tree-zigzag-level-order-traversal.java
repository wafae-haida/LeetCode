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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean reverse = false;
        while(!deque.isEmpty()){
            int len = deque.size();
            List<Integer> lst = new ArrayList<>();
            for(int i = 0 ; i < len; i++){
                TreeNode node = deque.pollFirst();
                lst.add(node.val);
                if(node.left != null)
                    deque.addLast(node.left);
                if(node.right != null)
                    deque.addLast(node.right);
            }
            if(reverse)
                Collections.reverse(lst);
            res.add(new ArrayList<>(lst));
            reverse = !reverse;
        }
        return res;
    }
}
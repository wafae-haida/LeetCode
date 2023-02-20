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
root=3;preorder = [3,9,20,15,7]; inorder = [9,3,15,20,7];mid=1
root=9;preorder = [9,20];inorder=[9,3];mid=0
root=20;preorder = [20];inorder=[9];mid=0
20.left=null
20.right=null
9.left=20
9.right=

*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        int mid=0;
        for(int i=0;i<inorder.length;i++){
            if(preorder[0]==inorder[i])
                mid=i;
        }
        root.left=buildTree(Arrays.copyOfRange(preorder,1,mid+1),Arrays.copyOfRange(inorder,0,mid));
        root.right=buildTree(Arrays.copyOfRange(preorder,mid+1,preorder.length),Arrays.copyOfRange(inorder,mid+1,inorder.length));
        return root;
    }
}
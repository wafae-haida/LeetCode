class Solution 
{
    //function to check if a given node is leaf or not
    public boolean isLeaf(TreeNode root)
    {
        if(root==null)
          return false;
        if(root.left==null && root.right==null)
          return true;
        return false;
    }
    public int sumOfLeftLeaves(TreeNode root) 
    {
        int sum=0;// Initialize sum
        if(root!=null)
        {
            // If left of root is NULL, then add key of left child
            if(isLeaf(root.left))
              sum+=root.left.val;
            else// Else recur for left child of root
              sum+=sumOfLeftLeaves(root.left);
            sum+=sumOfLeftLeaves(root.right);
            // Recur for right child of root and update sum
        }
        return sum;// return sum
    }
}
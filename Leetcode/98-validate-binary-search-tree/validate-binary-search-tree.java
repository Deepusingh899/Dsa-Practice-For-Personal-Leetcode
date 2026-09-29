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
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean leftSide=isValidBST(root.left);
        if(prev!=null && root.val<=prev.val) return false;
        prev=root;
        boolean rightSide=isValidBST(root.right);
        return leftSide && rightSide;
        // return true;        
    }
    // public boolean validBST(TreeNode root,TreeNode min,TreeNode max){
    //     if(root==null) return true;
    //     if(max!=null && root.val>= max.val) return false;
    //     if(min!=null && root.val<=min.val) return false;
    //     return validBST(root.left,min,root) && validBST(root.right,root,max);
    // }
}
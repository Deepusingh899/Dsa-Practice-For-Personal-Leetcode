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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return isSymmetricHelp(root.left,root.right);
    }
    public boolean isSymmetricHelp(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot==null || rightRoot==null) return leftRoot==rightRoot;
        if(leftRoot.val!=rightRoot.val) return false;
        return isSymmetricHelp(leftRoot.left,rightRoot.right)&& isSymmetricHelp(leftRoot.right,rightRoot.left);

    }
}
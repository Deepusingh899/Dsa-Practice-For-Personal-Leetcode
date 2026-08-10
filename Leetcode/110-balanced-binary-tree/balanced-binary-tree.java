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
    public int hieght(TreeNode root){
        if(root==null) return 0;
        int leftTree=hieght(root.left);
        int rightTree=hieght(root.right);
        if(leftTree==-1 || rightTree==-1) return -1;
        if(Math.abs(leftTree-rightTree)>1)return -1;
        return Math.max(leftTree,rightTree)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftHeight=hieght(root);
        return leftHeight!=-1 ? true : false;

        
    }
}
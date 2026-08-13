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
    int poIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        poIdx=postorder.length-1;
        return binaryTree(inorder,postorder,0,inorder.length-1);        
    }
    public TreeNode binaryTree(int[] inorder,int[] postorder,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[poIdx]);
        poIdx--;
        int inIdx=search(inorder,root.val,left,right);
        root.right=binaryTree(inorder,postorder,inIdx+1,right);
        root.left=binaryTree(inorder,postorder,left,inIdx-1);;
        return root;
    }
    public int search(int[] inorder,int val,int left,int right){
        for(int i=left;i<=right;i++){
            if(inorder[i]==val) return i;
        }
        return -1;
    }
}
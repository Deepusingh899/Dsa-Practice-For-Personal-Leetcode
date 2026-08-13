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
    private int preIdx=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return binaryTree(preorder,0,inorder.length-1);
    }
    public TreeNode binaryTree(int[] preorder,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[preIdx]);
        preIdx++;
        int inIdx=map.get(root.val);
        root.left=binaryTree(preorder,left,inIdx-1);
        root.right=binaryTree(preorder,inIdx+1,right);
        return root;
    }
}
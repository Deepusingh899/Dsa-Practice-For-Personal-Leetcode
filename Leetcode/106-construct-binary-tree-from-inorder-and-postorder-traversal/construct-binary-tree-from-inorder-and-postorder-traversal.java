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
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        poIdx=postorder.length-1;        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return binaryTree(postorder,0,inorder.length-1);        
    }
    public TreeNode binaryTree(int[] postorder,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[poIdx]);
        poIdx--;
        int inIdx=map.get(root.val);
        root.right=binaryTree(postorder,inIdx+1,right);
        root.left=binaryTree(postorder,left,inIdx-1);;
        return root;
    }
}
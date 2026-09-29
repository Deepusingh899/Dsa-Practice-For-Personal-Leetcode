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
    List<Integer> list=new ArrayList<>();
    TreeNode IP=null;
    public List<Integer> inorderTraversal(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                list.add(root.val);
                root=root.right;
            }else{
                IP=root.left;
                while(IP.right!=null  && IP.right!=root){
                    IP=IP.right;
                }
                if(IP.right==null){
                    IP.right=root;
                    root=root.left;
                }else{
                    IP.right=null;
                    list.add(root.val);
                    root=root.right;
                }
            }
        }
        // if(root==null) return list;
        // inorderTraversal(root.left);
        // list.add(root.val);
        // inorderTraversal(root.right);
        return list;
    }
}
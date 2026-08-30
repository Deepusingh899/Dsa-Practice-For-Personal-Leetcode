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
    TreeNode IP=null;
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
       dfs(root);
       int temp=first.val;
       first.val=second.val;
       second.val=temp;        
    }
    public void dfs(TreeNode root){
         while(root!=null){
            if(root.left==null){
                if(prev!=null && prev.val> root.val){
                    if(first==null){
                        first=prev;
                    }
                    second=root;
                }
                prev=root;
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
                    if(prev!=null && prev.val> root.val){
                        if(first==null){
                            first=prev;
                        }
                        second=root;
                    }
                    prev=root;
                    root=root.right;
                }
            }
        }
    }
}
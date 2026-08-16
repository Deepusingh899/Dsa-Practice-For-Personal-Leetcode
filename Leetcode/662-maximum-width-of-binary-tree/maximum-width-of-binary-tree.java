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
    public class Pair {
        TreeNode root;
        int idx;
        Pair(TreeNode root,int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size=q.size();
            int start=0,end=0;
            for(int i=0;i<size;i++){
                Pair p=q.remove();
                int index=p.idx;
                if(i==0) start=index;
                if(i==size-1) end=index;
                if(p.root.left!=null) q.add(new Pair(p.root.left,2*index+1));
                if(p.root.right!=null) q.add(new Pair(p.root.right,2*index+2));
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
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
        Deque<Pair> q=new ArrayDeque<>();
        q.addLast(new Pair(root,0));
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size=q.size();
            int start=q.getFirst().idx,end=q.getLast().idx;
            for(int i=0;i<size;i++){
                Pair p=q.removeFirst();
                if(p.root.left!=null) q.addLast(new Pair(p.root.left,2*p.idx+1));
                if(p.root.right!=null) q.addLast(new Pair(p.root.right,2*p.idx+2));
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
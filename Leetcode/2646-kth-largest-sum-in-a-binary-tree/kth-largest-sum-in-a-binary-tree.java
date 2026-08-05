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
    public long kthLargestLevelSum(TreeNode root, int k) {
        long sum=0;
        Queue<TreeNode> q=new LinkedList<>();
        PriorityQueue<Long> pq=new PriorityQueue<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(node==null){
                pq.add(sum);
                sum=0;
                if(pq.size()>k) pq.poll();
                if(q.isEmpty()) break;
                else q.add(null);
                
            }else{
                sum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return pq.size()<k ? -1 : pq.poll();
    }
}
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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ans=Integer.MIN_VALUE;
        int level=1;
        int maxLevel=1;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
                sum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            // ans=Math.max(ans,sum);
            // level++;
            if(sum>ans) {
                maxLevel=level;
            }
            ans=Math.max(ans,sum);
            level++;          
        }
        return maxLevel;
    }
}
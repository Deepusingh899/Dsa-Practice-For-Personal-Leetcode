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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Deque<TreeNode> q=new ArrayDeque<>();
        q.addFirst(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> li=new ArrayList<>();
            if(level%2==0){
                for(int i=0;i<size;i++){
                    TreeNode node=q.removeFirst();
                    li.add(node.val);
                    if(node.left!=null) q.addLast(node.left);
                    if(node.right!=null) q.addLast(node.right);
                }
            }else{
                for(int i=0;i<size;i++){
                    TreeNode node=q.removeLast();
                    li.add(node.val);
                    if(node.right!=null) q.addFirst(node.right);
                    if(node.left!=null) q.addFirst(node.left);
                    
                }
            }
            level++;
            list.add(li);
        }
        
        return list;
    }
}
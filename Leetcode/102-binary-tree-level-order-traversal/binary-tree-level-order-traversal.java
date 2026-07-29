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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> li;
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return list;
        q.add(root);
        q.add(null);
        li=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode currNode=q.remove();
            if(currNode==null){
                list.add(li);
                li=new ArrayList<>();
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
                li.add(currNode.val);
                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);
            }
        }

        return list;
    }
}
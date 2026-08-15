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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        duplicate(root,map,list);
        return list;
    }
    public String duplicate(TreeNode root,HashMap<String,Integer> map,List<TreeNode> list){
        if(root == null) return "$";
        String left=duplicate(root.left,map,list);
        String right=duplicate(root.right,map,list);
        String str=root.val+","+left+","+right;
        map.put(str,map.getOrDefault(str,0)+1);
        if(map.get(str)==2) list.add(root);
        return str;
    }
}
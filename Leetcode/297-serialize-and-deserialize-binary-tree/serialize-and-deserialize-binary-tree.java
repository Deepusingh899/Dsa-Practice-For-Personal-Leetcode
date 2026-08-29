/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode node=q.remove();
            if(node==null){
                sb.append("n,");
                continue;
            }
            sb.append(node.val+",");
            q.add(node.left);
            q.add(node.right);
        }
        System.out.print("Serliaze :- "+sb.toString());
        return sb.toString();        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()<0 || data=="") return null;
        Queue<TreeNode> q=new LinkedList<>();
        String[] str=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        for(int i=1;i<str.length;i++){
            TreeNode node=q.remove();
            if(!str[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(str[i]));
                node.left=left;
                q.add(left);
            }
            i++;
            if(!str[i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(str[i]));
                node.right=right;
                q.add(right);
            }

        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
package BInaryTree;

public class Diameter {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] strgs){
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node .left.right=new Node(5);
        // node.right.left=new Node(6);
        // node.right.right=new Node(7);
        System.out.println(diameter1(node)); 
        System.out.println(diameter2(node).diam+" "+diameter2(node).ht);        
    }
    public static int diameter1(Node node){
        if(node==null) return 0;
        int ld=diameter1(node.left);
        int lh=height(node.left);
        int rd=diameter1(node.left);
        int rh=height(node.left);
        int selfDiam=lh+rh+1;
        return Math.max(selfDiam,Math.max(ld,rd));

    }
    public static class Info{
        int diam;
        int ht;
        Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter2(Node node){
        if(node==null) return new Info(0,0);
        Info leftInfo=diameter2(node.left);
        Info rightInfo=diameter2(node.right);
        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);

    }
    public static int height(Node root){
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    
}

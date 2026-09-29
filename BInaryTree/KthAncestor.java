package BInaryTree;

public class KthAncestor {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main (String[] args){
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);    
        node.right.right=new Node(6);
       /*        1
                / \
               2   3
              / \   \
             4   5   6*/
        int n=4,m=2;
        System.out.println(dist(node,n,m));
    }
    // public static int minDist(Node root,int n,int m){
    //     Node lcaNode=lca(root,n,m);
    //     int dist1=dist(lcaNode,n);
    //     int dist2=dist(lcaNode,m);
    //     return dist1+dist2;
        
    // }
    public static int dist(Node root,int n,int k){
        int max=0;
        if(root==null) return -1;
        if(root.data==n) return 0;
        int leftDist=dist(root.left,n,k);
        int rightDist=dist(root.right,n,k);
        if(leftDist==-1 && rightDist==-1) return -1;
        max=Math.max(leftDist,rightDist);
        if(max+1==k) System.out.println(root.data);
        return max+1;
    }
    public static Node lca(Node root,int n,int m){
        if(root==null) return null;
        if(root.data==n || root.data==m) return root;
        Node leftLca=lca(root.left,n,m);
        Node rightLca=lca(root.right,n,m);
        if(leftLca==null) return rightLca;
        if(rightLca==null) return leftLca;
        return root;
    }
    
}
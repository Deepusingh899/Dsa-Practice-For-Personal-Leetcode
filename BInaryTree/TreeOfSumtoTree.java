package BInaryTree;
public class TreeOfSumtoTree{    
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
        // int n=4,m=2;
        sumOfTree(node);
        preOrder(node);
    }
    public static int sumOfTree(Node root){
        if(root==null) return 0;
        int leftSum=sumOfTree(root.left);
        int rightSum=sumOfTree(root.right);
        int val=root.data;
        int newLeft=root.left!=null?root.left.data:0;
        int newRight=root.right!=null?root.right.data:0;
        root.data=newLeft+leftSum+newRight+rightSum;
        return val;
    }
    public static void preOrder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
    
package BInaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node preOrder(int[] arr){
            idx++;
            if(arr[idx]==-1){
                return null;
            }
            Node newNode =new Node(arr[idx]);
            newNode.left=preOrder(arr);
            newNode.right=preOrder(arr);
            return newNode;
        }
        public void preOrderTraversal(Node root){
            if(root==null) return ;
            System.out.print(root.data+"->");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
        public void inOrderTraversal(Node root){
            if(root==null) return ;
            inOrderTraversal(root.left);
            System.out.print(root.data+"->");
            inOrderTraversal(root.right);
        }
        public void postOrderTraversal(Node root){
            if(root==null) {
                System.out.print("-1->");
                return ;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+"->");
        }
        public void levelOrderTraversal(Node root){
            if(root==null) return ;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            // System.out.print(q.peek().data+"->");
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()) break;
                    q.add(null);
                }else{
                    System.out.print(currNode.data+"->");
                    if(currNode.left!=null) q.add(currNode.left);
                    if(currNode.right!=null) q.add(currNode.right);
                }
            }
        }
        public int height(Node root){
            if(root==null) return 0;
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh,rh)+1;
        }
        public int count(Node root){
            if(root==null) return 0;
            int lh=count(root.left);
            int rh=count(root.right);
            return lh+rh+1;
        }
        public int sumOfNodes(Node root){
            if(root==null) return 0;
            int lh=sumOfNodes(root.left);
            int rh=sumOfNodes(root.right);
            return lh+rh+ root.data;
        }
    }
    public static void main (String[] args){
        int[] arr={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.preOrder(arr);
        // System.out.println(root.data);
        tree.preOrderTraversal(root);
        System.out.println();
        tree.inOrderTraversal(root);
        System.out.println();
        tree.postOrderTraversal(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println(tree.height(root));
        System.out.println(tree.count(root));
        System.out.println(tree.sumOfNodes(root));
    }
    
}

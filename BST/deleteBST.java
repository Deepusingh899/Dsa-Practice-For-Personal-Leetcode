package BST;

public class deleteBST {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String [] args){
        int[] arr={5,3,6,2,4,7};
        Node node = null;
        for(int i=0;i<arr.length;i++){
            node=buildBST(node,arr[i]);
        }
        printInOrder(node);
        System.out.println("After Deletion");
        node=deleteNode(node,3);
        printInOrder(node);
    }
    public static Node buildBST(Node root,int val){
        if(root==null) {
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=buildBST(root.left,val);
        }else{
            root.right=buildBST(root.right,val);
        }
        return root;
    }
    public static void printInOrder(Node root){
        if(root==null) return ;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }
    public static Node deleteNode(Node root,int val){
        if(root==null) return null;
        if(root.data>val){
            root.left=deleteNode(root.left,val);
        }else if(root.data<val){
            root.right=deleteNode(root.right,val);
        }else{
            //Case 1 No Leaf Node 
            System.out.println("Deleting "+root.data);
            if(root.left==null && root.right==null) return null;
            
            //Case 2 one child
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;

            //Case 3 two child
            Node IN=findInorderSuccessor(root.right);
            root.data=IN.data;
            root.right= deleteNode(root.right,IN.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}

package BST;
class SearchBST{
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
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node node=null;
        for(int i=0;i<arr.length;i++){
            node=buildBST(arr[i],node);
        }
        // Node root = buildBST(arr,node);
        printInOrder(node);
        if(searchBST(node, 8)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
    public static Node buildBST(int val, Node root){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = buildBST(val,root.left);
        }else{
            root.right = buildBST(val,root.right);
        }
        return root;
    }
    public static void printInOrder(Node root){
        if(root==null) return ;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }
    public static boolean searchBST (Node root,int val){
        if(root==null) return false;
        if(root.data==val) return true;
        if(root.data>val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }
}

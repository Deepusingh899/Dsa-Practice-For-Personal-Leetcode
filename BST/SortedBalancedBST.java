package BST;
class SortedBalancedBST{
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
        int[] arr={3,5,6,8,10,11,12};
        printBST(balancedBST(arr,0,arr.length-1));
    }
    public static Node balancedBST(int [] arr,int l,int h){
        if(l>h) return null;
        int mid=(l+h)/2;;
        Node root=new Node(arr[mid]);
        root.left=balancedBST(arr,l,mid-1);
        root.right=balancedBST(arr,mid+1,h);
        return root;
    }
    public static void printBST(Node root){
        if(root==null) {
            System.out.print("Null ");
            return ;
        }
        System.out.print(root.data+" ");
        printBST(root.left);
        printBST(root.right);
    }
}
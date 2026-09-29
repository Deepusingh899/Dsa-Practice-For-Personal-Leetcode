package BInaryTree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TopView{

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static void main(String[] args) {
        Node tree = new Node(20);
        // tree.root = new Node(1);
        tree.left = new Node(8);
        tree.right = new Node(22);
        tree.left.left = new Node(5);
        tree.left.right = new Node(3);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(14);
        tree.right.right=new Node(25);
        /*  20
            / \
           8   22
          / \    \
         5   3   25
            / \
           10 14 */

        System.out.println("Top view of the binary tree:");
        printTopView(tree);
    }

    public static void printTopView(Node root){
        if(root==null) return ;
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;;
        q.add(new Info(root,0));
        // System.out.println("Min: "+min+" Max: "+max);
        q.add(null);
        while(!q.isEmpty()){
            Info curr=q.remove();
            // System.out.println(curr==null?"null":curr.node.data+" "+curr.hc);
            if(curr==null){
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
                if(!map.containsKey(curr.hc)){
                    map.put(curr.hc,curr.node.data);
                    min=Math.min(min,curr.hc);
                    max=Math.max(max,curr.hc);
                }
                if(curr.node.left!=null)q.add(new Info(curr.node.left,curr.hc-1));
                if(curr.node.right!=null)q.add(new Info(curr.node.right,curr.hc+1));
            }
        }
        print(map,min,max);
    }
    public static void print(HashMap<Integer,Integer> map,int min,int max){
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i)+" ");
        }
        System.out.println();
        System.out.println("Min: "+min+" Max: "+max);
    }
    static class Info{
        Node node;
        int hc;
        Info(Node node,int hc){
            this.node=node;
            this.hc=hc;
        }
    }
}
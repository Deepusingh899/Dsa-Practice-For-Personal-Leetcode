package LinkedList;
public class ZigZagLL {
    private Node head;
    private static Node tail;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    public void addLast(int data){
        Node newNode=new Node(data);
         if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public static Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node reverseNode(Node rightHead){
        Node currNode=rightHead;
        Node prev=null;
        Node next;
        while(currNode!=null){
            next=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=next;
        }
        return prev;
    }
    public void zigzag(){
        //find mid Node;
        Node midNode=getMid(head);
        //reverse 2ndHalf
        Node rightNode=midNode.next;
        midNode.next=null;
        Node rightHead=reverseNode(rightNode);
        Node leftHead=head;
        Node nextL,nextR;
        while(leftHead!=null && rightHead!=null){
            nextL=leftHead.next;
            leftHead.next=rightHead;
            nextR=rightHead.next;
            rightHead.next=nextL;
            leftHead=nextL;
            rightHead=nextR;
        }
    }
    public void printNode(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public static void main (String []args){
        ZigZagLL ll=new ZigZagLL();
        ll.addLast(0);
        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(3);
        ll.addLast(1);
        ll.printNode();
        System.out.println();
        ll.zigzag();
        ll.printNode();
        // System.out.println(mergeSort(head));        
    }
}

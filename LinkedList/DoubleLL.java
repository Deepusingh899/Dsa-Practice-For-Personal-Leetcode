package LinkedList;
public class DoubleLL{
    public static Node head;
    public static Node tail;
    public static int size;
    public class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            next=null;
            prev=null;
        }
    }
    public void addFirstDoubleLL(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public int removeFirstDoubleLL(){
        if(head==null){
            System.out.println("Doubly Linked List is Empty ");
            return Integer.MIN_VALUE;
        }
        if(head.next==null){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    public void print(){
        Node temp=head;
        System.out.print("null<-");
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void reverseDoubleLL(){
        Node currNode=head;
        Node prevNode=null;
        Node next;
        while(currNode!=null){
            next=currNode.next;
            currNode.next=prevNode;
            currNode.prev=next;
            prevNode=currNode;
            currNode=next;
        }
        head=prevNode;
    }
    public static void main(String []args){
        DoubleLL dll=new DoubleLL();
        dll.addFirstDoubleLL(3);
        dll.addFirstDoubleLL(2);
        dll.addFirstDoubleLL(1);
        dll.print();
        System.out.println(dll.size);
        // System.out.println(dll.removeFirstDoubleLL());
        dll.reverseDoubleLL();
        dll.print();
        // System.out.println(dll.size);
    }
}
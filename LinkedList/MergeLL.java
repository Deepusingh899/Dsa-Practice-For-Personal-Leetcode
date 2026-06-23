package LinkedList;
public class MergeLL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
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
    public static Node mergeSort(Node head){
        if(head==null || head.next==null) return head;
        Node midNode=getMid(head);
        Node rightNode=midNode.next;
        midNode.next=null;
        Node leftHalf=mergeSort(head);
        Node rightHalf=mergeSort(rightNode);
        return merge(leftHalf,rightHalf);
    }
    public static Node merge(Node leftHalf,Node rightHalf){
        Node extraNode=new Node(-1);
        Node temp=extraNode;
        while(leftHalf!=null && rightHalf!=null){
            if(leftHalf.data<=rightHalf.data){
                temp.next=leftHalf;
                leftHalf=leftHalf.next;
                temp=temp.next;
            }else{
                temp.next=rightHalf;
                rightHalf=rightHalf.next;
                temp=temp.next;
            }
        }
        while(leftHalf!=null){
            temp.next=leftHalf;
            leftHalf=leftHalf.next;
            temp=temp.next;
        }
        while(rightHalf!=null){
            temp.next=rightHalf;
            rightHalf=rightHalf.next;
            temp=temp.next;
        }
        return extraNode.next;
    }
    public static void printNode(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public static void main (String []args){
        // MergeLL ll=new MergeLL();
        Node head=new Node(1);
        head.next=new Node(3);
        head.next.next=new Node(7);
        head.next.next.next=new Node(2);
        head.next.next.next.next=new Node(10);
        head.next.next.next.next.next=new Node(4);
        printNode(head);
        System.out.println();
        printNode(mergeSort(head));
        // System.out.println(mergeSort(head));        
    }
}

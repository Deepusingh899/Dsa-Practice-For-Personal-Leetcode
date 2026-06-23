package LinkedList;



public class cycleLL {
    public static Node head ;
    public static Node tail;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    public static void removeCycle(){
        // Defect Cycle 
        Node slow=head;
        boolean flag=false;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                flag=true;
                slow=head;
                break;
            }
        }
        if(!flag) return ;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;

    }
    public static void main(String[] args){
        // cycleLL cll=new cycleLL();
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=head.next.next;
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
    
}

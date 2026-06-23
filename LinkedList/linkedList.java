package LinkedList;

public class linkedList {
    public static Node head;
    public static Node tail;
    public static int size = 1;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void addFirst(int data){ 
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
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
        size++;
    }
    public void addAtIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void printNode(){
        Node temp=head;
        System.out.print("Linked List = ");
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");

    }
    public int removeFirst(){
        int val=head.data;
        if(size==0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val1=head.data;
            head=null;
            tail=null;
            return val1;
        }
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        int val=tail.data;
        if(size==0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val1=tail.data;
            head=null;
            tail=null;
            return val1;
        }
        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    public int iterativeSearch(int key){
        if(size==0){
            System.out.println("Linked List is empty");
        }
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head,int key,int i){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return i;
        }
        i++;
        return helper(head.next,key,i);
    }
    public int recursiveSearch(int key){
        return helper(head,key,0);
        
    }
    public void reverseLL(){
        Node prev=null;
        Node curr=head;
        tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void deleteNthfromend(int n){
        if(n==size){
            head=head.next; //remove first node;
        }
        Node prev=head;
        for(int i=1;i<size-n;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
    }
    public Node findMiddle(){
        Node slow=head;
        Node fast=head;
        Node middle;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        };
        middle=slow;
        return middle;
    }
    public boolean checkPalindrome(){
        if(head==null || head.next==null) return true;
        Node MiddleNode=findMiddle();
        Node prev=null;
        Node curr=MiddleNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static void main(String[] args){
        linkedList ll=new linkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        // ll.addAtIndex(2, 3);
        // System.out.println("Index of Key :- "+ ll.iterativeSearch(4));
        System.out.println("Index of Key :- "+ ll.recursiveSearch(4));
        ll.printNode();
        // System.out.println("Size :- "+ll.size);
        // ll.deleteNthfromend(3);
        // ll.printNode();
        // ll.reverseLL();
        // ll.printNode();
        // System.out.println("Middle Node :- "+ll.findMiddle());
        // System.out.println("Deleted Value :- "+ ll.removeFirst());
        // System.out.println("Deleted Value :- "+ ll.removeLast());   
        System.out.println(ll.checkPalindrome()); 
    }
}

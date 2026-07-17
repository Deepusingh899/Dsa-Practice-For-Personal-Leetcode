package Queue;

public class QueueWithLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
        static Node head=null;
        static Node tail=null;
        public boolean isEmpty(){
            return head==null && tail==null;
        }
        public void add(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=tail.next;
        }
         public int remove(){
            if(isEmpty()){
                System.out.print("Empty Queue");
                return -1; 
            }
            int data=head.data;
            head=head.next;
            if(head==null){
                tail=null;
            }
            return data;
        }
        public int peek(){
            if(isEmpty()){
                System.out.print("Empty Queue");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[]args){
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.print(q.remove()+" ");
        q.add(4);
        System.out.print(q.remove()+" ");
        q.add(5);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
        System.out.println();
    }
}

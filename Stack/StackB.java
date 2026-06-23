package Stack;
import java.util.Stack;
public class StackB {
    // public static class Node{
    //     int data;
    //     Node next;
    //     Node(int data){
    //         this.data=data;
    //         this.next=null;
    //     }
    // }
    // public static class StackC{
    //     static Node head=null;
    //     public void push(int data){
    //         Node newNode=new Node(data);
    //         if(isEmpty()) {
    //             head=newNode;
    //             return;
    //         }
    //         newNode.next=head;
    //         head=newNode;
    //     }
    //     public int pop(){
    //         if(isEmpty()) return -1;
    //         int data=head.data;
    //         head=head.next;
    //         return data;
    //     }
    //     public int peek(){
    //         if(isEmpty()) return -1;
    //         return head.data;
    //     }
    //     public boolean isEmpty(){
    //         return head==null;
    //     }
    // }
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String[]args){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        pushAtBottom(st,7);
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
    
    
}

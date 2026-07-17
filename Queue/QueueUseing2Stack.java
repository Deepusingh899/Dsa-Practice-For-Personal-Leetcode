package Queue;
import java.util.*;
public class QueueUseing2Stack {
    static class Queue{
        static Stack<Integer> st1=new Stack<>();
        static Stack<Integer> st2=new Stack<>();
        public boolean isEmpty(){
            return st1.isEmpty();
        }
        public  void add(int data){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            st1.push(data);
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return st1.pop();
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return st1.peek();
        }
    }
    public static void main(String[] args){
        Queue q=new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}

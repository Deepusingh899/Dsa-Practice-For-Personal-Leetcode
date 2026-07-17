package Queue;

public class CircularQueue {
    static int size;
    static int [] arr;
    static int rear;
    static int front;
    static class Queue{
        Queue(int n){
            size=n;
            arr=new int[n];
            rear=-1;
            front=-1;
        }
        public void add(int data){
            if((rear+1)%size==front){
                System.out.println("Queue is full");
                return;
            }
            rear=(rear+1)%size;
            if(front==-1){
                front=0;
            }
            arr[rear]=data;
        }
        public int remove(){
            if(isEmpty()){
                System.out.print("Empty Queue");
                return -1;
            }
            int data=arr[front];
           
            if(rear==front){
                rear=-1;
                front=-1;
            }else{
                front=(front+1)%size;
            }
            return data;
        }
        public boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public int peek(){
            if(isEmpty()){
                System.out.print("Empty Queue");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[]args){
        Queue q=new Queue(5);
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


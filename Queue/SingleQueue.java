package Queue;

public class SingleQueue {
    static int size;
    static int [] arr;
    static int rear;
    static class Queue{
        Queue(int n){
            size=n;
            arr=new int[n];
            rear=-1;
        }
        public void add(int data){
            if(rear==size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear]=data;
        }
        public int remove(){
            if(isEmpty()){
                System.out.print("Empty Queue");
                return -1;
            }
            int data=arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return data;
        }
        public boolean isEmpty(){
            return rear==-1;
        }
        public int peek(){
            if(isEmpty()){
                System.out.print("Empty Queue");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[]args){
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }
        System.out.println();
        
    }
}

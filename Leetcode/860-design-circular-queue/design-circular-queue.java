class MyCircularQueue {
    int [] arr;
    int size;
    int rear;
    int front;
    public MyCircularQueue(int k) {
        arr=new int[k];
        size=k;
        rear=-1;
        front=-1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear=(rear+1)%size;
        if(front==-1){
            front=0;
        }
        arr[rear]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(rear==front) {
            rear=-1;
            front=-1;
        }else{
            front=(front+1)%size;
        }
        return true;
    }
    
    public int Front() {
        return front==-1 ? -1 : arr[front];
    }
    
    public int Rear() {
        return rear==-1 ? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        return rear==-1 && front==-1;
    }
    
    public boolean isFull() {
        return (rear+1)%size==front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
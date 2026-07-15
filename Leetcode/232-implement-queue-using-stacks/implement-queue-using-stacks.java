class MyQueue {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> st1=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!st.isEmpty()){
            st1.push(st.pop());
        }
        st.push(x);
        while(!st1.isEmpty()){
            st.push(st1.pop());
        }
    }
    
    public int pop() {
        if(st.isEmpty()) return -1;
        return st.pop();
    }
    
    public int peek() {
        if(st.isEmpty()) return -1;
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
package Stack;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()) return;
        int top=st.pop();
        reverseStack(st);
        pushAtBottom(st,top);
    }
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[]args){
        ReverseStack rs=new ReverseStack();
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // rs.printStack(s);
        reverseStack(s);
        rs.printStack(s);
    }
    
}

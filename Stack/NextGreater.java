package Stack;

import java.util.Stack;

public class NextGreater {
    public static void finalNextGreater(int arr[],int nextGreater[]){
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i);            
        }
    }
    public static void main(String[]args){
        int arr[]={5,4,3,3,0,1};
        int nextGreater[]=new int[arr.length];
        finalNextGreater(arr,nextGreater);
        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}

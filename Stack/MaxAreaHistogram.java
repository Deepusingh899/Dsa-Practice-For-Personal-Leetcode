package Stack;

import java.util.Stack;

public class MaxAreaHistogram {
    public static int[] nextSmaller(int arr[]){
        int[] nextSmaller=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            int curr=arr[i];
            while(!s.isEmpty() && arr[s.peek()]>=curr){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmaller[i]=arr.length;
            }else{
                nextSmaller[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0;i<nextSmaller.length;i++){
            System.out.print(nextSmaller[i]+" ");
        }
        System.out.println();
        return nextSmaller;
    }
    public static int[] prevSmaller(int arr[]){
        int[] prevSmaller=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            while(!s.isEmpty() && arr[s.peek()]>=curr){
                s.pop();
            }
            if(s.isEmpty()){
                prevSmaller[i]=-1;
            }else{
                prevSmaller[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0;i<prevSmaller.length;i++){
            System.out.print(prevSmaller[i]+" ");
        }
        System.out.println();
        return prevSmaller;
    }

    public static int maxAreaHistogram(int arr[]){
        int maxArea=0;
        int[] nextSmaller=nextSmaller(arr);
        int[] prevSmaller=prevSmaller(arr);
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int widht=nextSmaller[i]-prevSmaller[i]-1;
            int area=height*widht;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[] arr={2,4};
       int maxArea= maxAreaHistogram(arr);
       System.out.println(maxArea);
    }
}

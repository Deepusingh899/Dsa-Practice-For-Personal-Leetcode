import java.util.Stack;

class Solution {
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
        return prevSmaller;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int[] nextSmaller=nextSmaller(heights);
        int[] prevSmaller=prevSmaller(heights);
        for(int i=0;i<heights.length;i++){
            int height=heights[i];
            int widht=nextSmaller[i]-prevSmaller[i]-1;
            int area=height*widht;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}
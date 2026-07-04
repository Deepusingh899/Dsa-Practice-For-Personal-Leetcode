package Leetcode;

import java.util.Stack;
/*
    Approach to solve this problem
    1. we will find the next smaller and previous smaller for each element in the array
    2. We will use stack to find the next smaller and previous smaller for each element in the array and 
    store the index of next smaller and previous smaller in the array like we have we donne for previous porblem
    to prepare nextGreater
    3. Now we will calculate the area for each element in the array using the formula
        area=height*width
        where height=heights[i] and width=nextSmaller[i]-prevSmaller[i]-1
    4. We will keep track of the maximum area and return it at the end
    5. Time complexity of this solution is O(n) and space complexity is O(n)

*/
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

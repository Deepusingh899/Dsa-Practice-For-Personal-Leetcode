package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindow{
    public static void main(String[] args){
        int[] arr={1,3,-1,-3,5,3,6,7};
        int k=3;
        int n=arr.length;
        int[] ans=new int[n-k+1];
        // maxValue(arr, k, ans);
        slidingWindow(arr, k, ans);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }  
    public static void maxValue(int[] arr,int k,int ans[]){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        ans[0]=pq.peek();
        for(int i=k;i<arr.length;i++){
            while(!pq.isEmpty() && pq.peek()<=arr[i]){
                pq.remove();
            }
            pq.add(arr[i]);
            ans[i-k+1]=pq.peek();
        }
        // return ans;
    }
    public static void slidingWindow(int[] arr,int k,int[] ans){
        PriorityQueue<PQ> pq=new PriorityQueue<>(); 
        for(int i=0;i<k;i++){
            pq.add(new PQ(arr[i],i));
        }
        ans[0]=pq.peek().val;
        for(int i=k;i<arr.length;i++){
            while(!pq.isEmpty() && pq.peek().i<=(i-k)){
                pq.remove();
            }
            pq.add(new PQ(arr[i],i));
            ans[i-k+1]=pq.peek().val;
        }
    }
    public static class PQ implements Comparable<PQ>{
        int val;
        int i;
        public PQ(int val,int i){
            this.val=val;
            this.i=i;
        }
        @Override
        public int compareTo(PQ o) {
            return o.val-this.val;
        }
    }

}
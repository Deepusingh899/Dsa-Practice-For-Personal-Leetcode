package Heap;

import java.util.PriorityQueue;

public class NearestCar {
    public static void main(String[] args){
        int[][] arr={{1,2},{3,4},{1,-1}};
        int k=2;
        PriorityQueue<HeapNode> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int x=arr[i][0];
            int y=arr[i][1];;
            int sqrDist=x*x+y*y;
            pq.add(new HeapNode(sqrDist,i));
        }
        for(int i=0;i<k;i++){
            HeapNode node=pq.poll();
            System.out.println("C"+node.i);
        }

    }
    public static class HeapNode implements Comparable<HeapNode>{
        int sqrDist;
        int i;
        public HeapNode(int sqrDist,int i){
            this.sqrDist=sqrDist;
            this.i=i;
        }

        @Override 
        public int compareTo(HeapNode other){
            return this.sqrDist-other.sqrDist;
        }
    }
    
}

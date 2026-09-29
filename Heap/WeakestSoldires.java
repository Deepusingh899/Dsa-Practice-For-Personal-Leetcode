package Heap;

import java.util.PriorityQueue;

public class WeakestSoldires {
    public static class Row implements Comparable<Row>{
        int soldiers;
        int i;
        public Row(int soldiers,int i){
            this.soldiers=soldiers;
            this.i=i;
        }
        @Override
        public int compareTo(Row o) {
            if(this.soldiers==o.soldiers){
                return this.i-o.i;
            }
            return this.soldiers-o.soldiers;
        }
    }
    public static void main(String[] args){
        int[][] arr={
            {1,0,0,0,0},
            {1,1,1,1,1},
            {1,0,0,0,0},
            {1,0,0,0,0}
        };
        int k=2;

        PriorityQueue<Row> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr[i].length;j++){
                count+=arr[i][j]==1 ? 1:0;
            }
            pq.add(new Row(count, i));
        }
        for(int i=0;i<k;i++){
            System.out.println("R"+pq.poll().i);
        }
    }
    
}

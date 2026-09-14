class Solution {
    public class Closest implements Comparable<Closest> {
        int [] arr;
        int dist;
        Closest(int arr[],int dist){
            this.arr=arr;
            this.dist=dist;
        }
        @Override
        public int compareTo(Closest cl){
            return this.dist-cl.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Closest> pq=new PriorityQueue<>();
        for(int [] num:points){
            int a=num[0];
            int b=num[1];
            int dist=a*a+b*b;
            pq.add(new Closest(num,dist));
            
        }
        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().arr + " "+pq.peek().dist);
        //     pq.poll();
        // }
        int [][]nums=new int[k][];
        for(int i=0;i<k;i++){
            nums[i]=pq.poll().arr;
        }
        return nums;
    }
}
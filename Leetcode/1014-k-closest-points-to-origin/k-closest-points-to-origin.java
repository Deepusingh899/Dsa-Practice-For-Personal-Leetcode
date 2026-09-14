class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> dist(b) - dist(a));
        for(int [] num:points){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int [][]nums=new int[k][];
        for(int i=0;i<k;i++){
            nums[i]=pq.poll();
        }
        return nums;
    }
     public int dist(int arr[]){
            int a=arr[0];
            int b=arr[1];
            return a*a+b*b;
        }
}
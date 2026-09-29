class Solution {
    public class Week implements Comparable<Week>{
        int i;
        int count;
        public Week(int i,int count){
            this.i=i;
            this.count=count;
        }

        @Override
        public int compareTo(Week w){
            if(this.count==w.count){
                return this.i-w.i;
            }else{
                return this.count-w.count;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int ans[]=new int[k];
        PriorityQueue<Week> pq=new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[0].length;j++){
                count+= mat[i][j]==1 ? 1 : 0;
            }
            pq.add(new Week(i,count));
        }
        for(int i=0;i<k;i++){
            ans[i]=pq.poll().i;
        } 
        return ans;       
    }
}
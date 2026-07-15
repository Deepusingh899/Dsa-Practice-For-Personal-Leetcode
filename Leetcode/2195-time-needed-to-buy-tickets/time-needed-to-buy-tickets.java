class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int t=0;
        for(int i=0;i<tickets.length;i++){
            if(i<=k){
                t+=Math.min(tickets[i],tickets[k]);
            }else{
                t+=Math.min(tickets[i],tickets[k]-1);
            }
        }
        // int t=0;
        // Queue<Integer> q=new LinkedList<>();
        // int n=tickets.length;
        // for(int i=0;i<n;i++){
        //     q.add(i);
        // }
        // while(!q.isEmpty()){
        //     tickets[q.peek()]--;
        //     t++;
        //     if(tickets[q.peek()]>0) q.add(q.remove());
        //     if(q.peek()==k && tickets[q.peek()]==0) return t;
        // }
        return t;
    }
}
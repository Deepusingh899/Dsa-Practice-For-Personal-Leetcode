class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k){
                pq.offer(nums[i]);
            }else if(nums[i]>pq.peek()){
                pq.offer(nums[i]);
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        if(pq.size()<k)  pq.offer(val);
        else if(val>pq.peek()){
            pq.offer(val);
            pq.poll();
        }
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
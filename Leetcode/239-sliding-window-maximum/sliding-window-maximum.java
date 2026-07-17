class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length-k+1;
        int[] arr=new int[n];
        // List<Integer> list=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         int j=i;
    //         int max=0;
    //         while(j<k+i){
    //             max=Math.max(nums[j],max);
    //         }
    //         arr[i]=max;
    //     }
    //    return arr;
        Deque<Integer> dq=new LinkedList<>(); 
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        arr[0]=nums[dq.getFirst()];
        for(int i=k;i<nums.length;i++){
            if(i-dq.getFirst()+1>k) dq.removeFirst();
            while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            arr[i-k+1]=nums[dq.getFirst()];
        }
        return arr;
    }
}
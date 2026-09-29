class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap will store all the prefixSum upto the index <Sum, Frequency>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int Sum = 0; // Actual Sum upto the Index
        
        // If prefixSum - k = 0, it means the subarray starts from index 0.
        // We add (0, 1) to handle this case naturally.
        map.put(0, 1); 

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            Sum += nums[i];               // Accumulate sum
            
            int remove = Sum - k;         // Calculate what previous sum we need to chop off
            
            // If HashMap contains the exact prefixSum to remove, it means we found valid subarrays
            if(map.containsKey(remove)){         
                ans += map.get(remove);
            }
            
            // Store/Update the current prefixSum frequency in the map
            map.put(Sum, map.getOrDefault(Sum, 0) + 1); 
        }
        return ans;
    }
}
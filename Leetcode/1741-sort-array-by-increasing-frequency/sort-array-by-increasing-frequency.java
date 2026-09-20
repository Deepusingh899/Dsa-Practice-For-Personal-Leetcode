class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Integer[] num=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            num[i]=nums[i];
        }
        Arrays.sort(num,(a,b) -> {
            return map.get(a)==map.get(b) ? b-a : map.get(a) - map.get(b);
        });
        //int []arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=num[i];
        }
        return nums;
    }
}
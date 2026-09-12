class Solution {
    public class Range implements Comparable<Range>{
        int element;
        int liIdx;
        int eleIdx;
        Range(int element,int liIdx,int eleIdx){
            this.element=element;
            this.liIdx=liIdx;
            this.eleIdx=eleIdx;
        }

        @Override
        public int compareTo(Range r1){
            return this.element-r1.element;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Range> pq=new PriorityQueue<>();
        int max=Integer.MIN_VALUE;
        int []arr = {0,Integer.MAX_VALUE};
        for(int i=0;i<nums.size();i++){
            pq.add(new Range(nums.get(i).get(0),i,0));
            max=Math.max(max,nums.get(i).get(0));
        }
        // System.out.println(max);
        while(true){
            Range data=pq.poll();
            int ele=data.element;
            int Idx=data.liIdx;
            int eleIdx=data.eleIdx;
            if(max-ele<arr[1]-arr[0]){
                arr[0]=ele;
                arr[1]=max;
            }
            if(eleIdx==nums.get(Idx).size()-1) break;
            max=Math.max(max,nums.get(Idx).get(eleIdx+1));
            pq.add(new Range(nums.get(Idx).get(eleIdx+1),Idx,eleIdx+1));
        }
        return arr;
    }
}
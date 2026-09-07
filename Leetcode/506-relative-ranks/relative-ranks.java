class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] str=new String[n];
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i; // store original index
        }

        // Sort indices based on scores in descending order
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);
        for(int i=0;i<n;i++){
            if(i==0) str[indices[i]]="Gold Medal"; 
            else if(i==1) str[indices[i]]="Silver Medal"; 
            else if(i==2) str[indices[i]]="Bronze Medal"; 
            else str[indices[i]]=String.valueOf(i+1); 
        }
        return str;
    }
}
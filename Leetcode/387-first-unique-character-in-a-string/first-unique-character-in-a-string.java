class Solution {
    public int firstUniqChar(String s) {
        Queue<Integer> q= new LinkedList<>();
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            q.add(ch-'a');
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()]>1){
                q.remove();
            }
        }
        System.out.println(q);
        if(q.isEmpty()) return -1;
        return s.indexOf((char)(97+q.peek()));
    }
}
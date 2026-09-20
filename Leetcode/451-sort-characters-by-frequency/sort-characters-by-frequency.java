class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] ch= s.toCharArray();
        for(int i=0;i<ch.length;i++){
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
        } 
        PriorityQueue<Character> pq= new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.poll();
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();      
    }
}
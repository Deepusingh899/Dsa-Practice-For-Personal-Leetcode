class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] ch= s.toCharArray();
        for(int i=0;i<ch.length;i++){
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
        } 
        PriorityQueue<Map.Entry<Character,Integer>> pq= new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> chara=pq.poll();
            sb.append(String.valueOf(chara.getKey()).repeat(chara.getValue()));
        }
        return sb.toString();      
    }
}
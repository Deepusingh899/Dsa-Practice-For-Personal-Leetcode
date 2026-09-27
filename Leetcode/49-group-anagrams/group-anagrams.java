class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        // List<List<String>> list= new ArrayList<>();
        for(String s: strs){
            String original=s;
            String[] str=s.split("");
            Arrays.sort(str);
            s=String.join("",str);
            if(!map.containsKey(s)) map.put(s,new ArrayList<>());
            map.get(s).add(original);
        }
        return new ArrayList<>(map.values());
        
    }
}
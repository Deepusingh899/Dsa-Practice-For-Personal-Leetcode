class Solution {
    public int calPoints(String[] operations) {
        System.out.println(Integer.parseInt("-2"));
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<operations.length;i++){
            if(list.size()>0 && "C".equals(operations[i])){
                list.remove(list.size()-1);
            }else if(list.size()>0 && "D".equals(operations[i])){
                list.add(list.get(list.size()-1)*2);
            }else if(list.size()>0 && "+".equals(operations[i])){
                list.add(list.get(list.size()-2)+list.get(list.size()-1));
            }else{
                list.add(Integer.parseInt(operations[i]));
            }
        }
        int ans=0;
        for(int i=0;i<list.size();i++){
            ans+=list.get(i);
        }
        return ans;
    }
}
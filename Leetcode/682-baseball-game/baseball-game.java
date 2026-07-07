class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            if("+".equals(operations[i])){
                int top=st.pop();
                int top1=st.peek();
                st.push(top);
                st.push(top+top1);
            }else if("C".equals(operations[i])){
                st.pop();
            }else if("D".equals(operations[i])){
                st.push(st.peek()*2);
            }else{
                st.push(Integer.parseInt(operations[i]));
            }
            // if(list.size()>0 && "C".equals(operations[i])){
            //     list.remove(list.size()-1);
            // }else if(list.size()>0 && "D".equals(operations[i])){
            //     list.add(list.get(list.size()-1)*2);
            // }else if(list.size()>0 && "+".equals(operations[i])){
            //     list.add(list.get(list.size()-2)+list.get(list.size()-1));
            // }else{
            //     list.add(Integer.parseInt(operations[i]));
            // }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}
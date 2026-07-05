class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=']'){
                st.push(ch);
            }else{
                StringBuilder sb=new StringBuilder();
                while(!s.isEmpty() && st.peek()!='['){
                    sb.append(st.pop());
                }
                st.pop();
                int temp=1;
                int num=0;
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num=(st.pop()-'0')*temp+num;
                    temp*=10;
                }
                while(num!=0){
                    for(int j=sb.length()-1;j>=0;j--){
                        st.push(sb.charAt(j));
                    }
                    num--;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
        
    }
}
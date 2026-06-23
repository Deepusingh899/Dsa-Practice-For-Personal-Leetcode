package Stack;
import java.util.*;
public class ReverseString {

    public String reverseString(String s,int i){
        Stack<Character> st=new Stack<>();
        while(i<s.length()){
            st.push(s.charAt(i));
            i++;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString().trim();
    }
    public static void main(String[]args){
        ReverseString rs=new ReverseString();
        String s="abcd";
        String res=rs.reverseString(s,0);
        System.out.print(res);
    }
    
}

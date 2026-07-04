package Stack;

import java.util.Stack;

public class DuplicateParanthesis {
    public static boolean duplicateParanthesis(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
           if(str.charAt(i)!=')') s.push(str.charAt(i));
           else{
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1) return true;
                else s.pop();
           }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+(C+d))";
        System.out.println(duplicateParanthesis(str));
    }    
}

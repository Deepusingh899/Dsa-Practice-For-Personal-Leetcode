package Tries;

public class longestWord {
    public static class Node{
        Node[] child=new Node[26];
        boolean eow;
        Node(){
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
        }
        curr.eow=true;
    }
    public static String ans="";
    public static void longestword(Node root,StringBuilder temp){
        if(root==null) return;
        for(int i=0;i<26;i++){
            char ch=(char)(i+'a');
            if(root.child[i]!=null && root.child[i].eow){
                temp.append(ch);
                if(temp.length()>ans.length()) ans=temp.toString();
                longestword(root.child[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args){
        String[] word={"a","banana","ap","app","appl","apple","apply"};
        for(String words : word){
            insert(words);
        }
        StringBuilder temp=new StringBuilder();
        longestword(root,temp);
        System.out.println(ans);
    }

}

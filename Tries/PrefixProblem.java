package Tries;
public class PrefixProblem{
    public static class Node{
        Node[] child= new Node[26];
        boolean eod=false;
        int freq;
        Node(){
            freq=0;
        }
    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(char ch: word.toCharArray()){
            int idx=ch-'a';
            if(curr.child[idx]==null)
                curr.child[idx]=new Node();
            curr=curr.child[idx];
            curr.freq++;
        }
        curr.eod=true;
    }
    public static String findPrefix(String word){
        Node curr=root;
        StringBuilder ans=new StringBuilder();
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            ans.append(ch);
            curr=curr.child[idx];
            if(curr.freq==1){
               return ans.toString();
            }
            
        }
        return word;
    }
    public static void main(String[] args){
        String[] words={"apple","app","mango","man","woman"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        // root.freq=-1;
        // for(int i=0;i<26;i++){}
        for(String word: words){
            System.out.println(findPrefix(word));
        }
    }
}
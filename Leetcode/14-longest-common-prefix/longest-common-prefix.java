class Solution {
    class TrieNode{
        TrieNode child[]=new TrieNode[26];
        boolean eow=false;
        int freq;
        TrieNode(){
            freq=0;
        }
    }
    public TrieNode root=new TrieNode();
    public void insert(String word){
        TrieNode curr=root;
        for(char ch : word.toCharArray()){
            int idx=ch-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new TrieNode();
                curr.freq++;
            }
            curr=curr.child[idx];
        }
        curr.eow=true;
    }
    public String longestPrefix(String word){
        TrieNode curr=root;
        StringBuilder sb=new StringBuilder();
        while(curr!=null && curr.freq==1 && !curr.eow){
            for(int i=0;i<26;i++){
                char ch=(char)(i+'a');
                if(curr.child[i]!=null){
                    sb.append(ch);
                    curr=curr.child[i];
                    break;
                }
                
            }
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        for(String word:strs){
            insert(word);
        }
        String ans="";
        for(String word: strs){
            ans =longestPrefix(word);
        }
        return ans;
    }
}
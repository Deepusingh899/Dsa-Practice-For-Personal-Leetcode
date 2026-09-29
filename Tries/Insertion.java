package Tries;

public class Insertion{

    public static class Node{
        Node[] child;
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
    } 
    public static void main (String[] args){
       String  words[]={"the","a","there","answer","any","by","bye","their"};
       for(int i=0;i<words.length;i++){
            insert(words[i]);
       }
    }
}
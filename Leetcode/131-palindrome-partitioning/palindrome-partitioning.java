class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        getAllParts(s,new ArrayList<>(),ans); 
        return ans;       
    }
    public void getAllParts(String s,List<String> res,List<List<String>> ans){
        if(s.length()==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=0;i<s.length();i++){
            String part=s.substring(0,i+1);
            System.out.println(isPalindrome(part));
            if(isPalindrome(part)){
                res.add(part);
                getAllParts(s.substring(i+1),res,ans);
                res.remove(res.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s1){
        char[] charArr=s1.toCharArray();
        String s2="";
        int i=0;
        int j=s1.length()-1;
        while(i<=j){
            if(s1.charAt(i)!=s1.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
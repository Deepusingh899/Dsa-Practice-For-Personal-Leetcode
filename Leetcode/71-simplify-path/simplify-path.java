class Solution {
    public String simplifyPath(String path) {
        String [] strStruct=path.split("/");

        Stack<String> s=new Stack<>();
        for(String str:strStruct){
            // System.out.println(str);
            if(str.equals("") || str.equals(".")) continue;
            if(str.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else  s.push(str);
        }
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }
        StringBuilder sb=new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0,"/"+s.pop());
        }
        if(sb.length()==0) return "/";
        else return sb.toString();
    // return path;
    }
    // return 
}
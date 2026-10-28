class Solution {
    static int count=0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        count=0;
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        dfs(rooms,vis,0);
        if(count!=n) return false;
        return true;
        
    }
    public void dfs(List<List<Integer>>rooms,boolean[]vis,int src){
        vis[src]=true;
        count++;
        for(int des:rooms.get(src)){
            if(!vis[des]){
                dfs(rooms,vis,des);
            }
        }
    }
}
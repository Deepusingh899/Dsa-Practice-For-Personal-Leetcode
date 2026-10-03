class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis=new boolean[n];
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<>());
        for(int[] e : edges){
            ans.get(e[0]).add(e[1]);
            ans.get(e[1]).add(e[0]);
        }
        return has(ans,source,destination,vis);
    }
    public static boolean has(List<List<Integer>> graph,int src,int des,boolean[] vis){
        if(src==des) return true;
        vis[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            int dest=graph.get(src).get(i);
            if(!vis[dest] && has(graph,dest,des,vis)){
                return true;
            }
        }
        return false;
    }
}
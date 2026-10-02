class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            list.get(pre[1]).add(pre[0]);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] par=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(list,vis,par,i)) return false;
            }
        }
       return true; 
    }
    public boolean dfs(List<List<Integer>> graph,boolean[] vis,boolean[] par,int curr){
        vis[curr]=true;
        par[curr]=true;
        for(int i=0;i<graph.get(curr).size();i++){
            int next=graph.get(curr).get(i);
            if(!vis[next]) {
                if(dfs(graph,vis,par,next)) return true;
            }else if(par[next]) return true;
        }
        par[curr]=false;
        return false;
    }
}
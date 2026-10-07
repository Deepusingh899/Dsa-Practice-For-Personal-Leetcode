class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int count=0;
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int [] indeg=new int[numCourses];
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;

        }
        Queue<Integer> q=new LinkedList<>();
        int[] ans=new int[numCourses];
        int idx=0;
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int ele=q.poll();
            ans[idx++]=ele;
            count++;
            for(int i=0;i<graph.get(ele).size();i++){
                int next=graph.get(ele).get(i);
                indeg[next]--;
                if(indeg[next]==0) q.add(next);

            }         

        }
        return count==numCourses ? ans : new int[0];
        
    }
}
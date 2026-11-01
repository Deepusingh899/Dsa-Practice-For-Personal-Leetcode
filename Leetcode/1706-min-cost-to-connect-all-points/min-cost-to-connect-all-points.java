class Pair {
    int vert;
    int cost;
    Pair(int vert,int cost){
        this.vert=vert;
        this.cost=cost;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>> graph= new ArrayList<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<graph.size();i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                graph.get(i).add(new Pair(j,dist));
                graph.get(j).add(new Pair(i,dist));
            }
        }
        boolean[] vis=new boolean[n];

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.add(new Pair(0,0));
        int finalCost=0;
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int node=temp.vert;
            int cost=temp.cost;
            if(vis[node]) continue;
            vis[node]=true;
            finalCost+=cost;
            for(Pair p: graph.get(node)){
                int ver=p.vert;
                int co=p.cost;
                if(!vis[ver]){
                    pq.add(new Pair(ver,co));
                }
            }
        }
        return finalCost;
    }
}
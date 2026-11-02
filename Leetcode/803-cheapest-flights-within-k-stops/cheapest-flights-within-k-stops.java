class Solution {
    class Edge{
        int src;
        int des;
        int wt;
        Edge(int src,int des,int wt){
            this.src=src;
            this.des=des;
            this.wt=wt;
        }
    }
    class Pair{
        int ver;
        int cost;
        int stop;
        Pair(int ver,int cost,int stop){
            this.ver=ver;
            this.cost=cost;
            this.stop=stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int srrc=flights[i][0];
            int des=flights[i][1];
            int wt=flights[i][2];
            graph.get(srrc).add(new Edge(srrc,des,wt));
        }
        int [] dist=new int[n];
        for(int i=0;i<n;i++){
            if(i!=src) dist[i]=Integer.MAX_VALUE;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0,0));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            if(curr.stop>k) break;
            for(int i=0;i<graph.get(curr.ver).size();i++){
                Edge e=graph.get(curr.ver).get(i);
                int v=e.des;
                int wt=e.wt;
                int cost=curr.cost;
                if(cost+wt<dist[v] && curr.stop<=k){
                    dist[v]=cost+wt;
                    q.add(new Pair(v,dist[v],curr.stop+1));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
        
    }
}
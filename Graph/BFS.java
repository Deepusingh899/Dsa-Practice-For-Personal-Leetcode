package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static class Edge{
        int src;
        int des;
        Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    public static void main (String[] args){
        /*  1-----3
           /      | \
          /       |  \
        0         |   5------6
          \       |  /
           \      | /
            2-----4 
        */
        ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
        int V=7;
        createGraph(graph,V);
        for(int i=0;i<graph.get(3).size();i++){
            System.out.print(graph.get(3).get(i).des+" ");
        }
        System.out.println();
        bfs(graph,V);
    }

    public static void createGraph(ArrayList<ArrayList<Edge>> graph,int V){

        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0,1));
        graph.get(0).add(new Edge(1,2));

        graph.get(1).add(new Edge(1,3));

        graph.get(2).add(new Edge(2,0));
        graph.get(2).add(new Edge(2,4));

        graph.get(3).add(new Edge(3,4));
        graph.get(3).add(new Edge(3,5));
        graph.get(3).add(new Edge(3,1));

        graph.get(4).add(new Edge(4,5));
        graph.get(4).add(new Edge(4,3));
        graph.get(4).add(new Edge(4,2));

        graph.get(5).add(new Edge(5,3));
        graph.get(5).add(new Edge(5,4));
        graph.get(5).add(new Edge(5,6));

        graph.get(6).add(new Edge(6,5));

    }    
    public static void bfs(ArrayList<ArrayList<Edge>>graph,int V){
        boolean[] vis=new boolean[V];
        Queue<Integer> q=new LinkedList<>(); 
        q.add(graph.get(0).get(0).src);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph.get(curr).size();i++){
                    Edge e=graph.get(curr).get(i);
                    q.add(e.des);
                }
            }
            
        }
    }
}

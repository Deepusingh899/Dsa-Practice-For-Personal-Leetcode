package Graph;

import java.util.ArrayList;

public class HashPath {
    static class Edge{
        int src;
        int des;
        Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
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

        graph.get(4).add(new Edge(4,2));
        graph.get(4).add(new Edge(4,3));
        graph.get(4).add(new Edge(4,5));

        graph.get(5).add(new Edge(5,3));
        graph.get(5).add(new Edge(5,4));
        graph.get(5).add(new Edge(5,6));

        graph.get(6).add(new Edge(6,5));

    }    
    public static boolean has(ArrayList<ArrayList<Edge>>graph,int src,int des,boolean[] vis){
        if(src==des) return true;
        vis[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            Edge e=graph.get(src).get(i);
            if(!vis[e.des] && has(graph,e.des,des,vis)){
                return true;
            }
        }
        return false;
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
        System.out.println(has(graph,0,7,new boolean[7]));
    }
}

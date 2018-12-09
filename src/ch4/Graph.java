package ch4;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private int E;
    private List<Integer>[] adj;
    public Graph(int v){
        this.V = v;
        adj = new List[v];
        for(int i = 0;i< v;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public int V(){return V;}

    public int E(){return E;}

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}

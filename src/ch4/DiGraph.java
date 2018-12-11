package ch4;

import java.util.ArrayList;
import java.util.List;

public class DiGraph {
    private final int V ;

    List<Integer> adj[];

    public int V(){
        return V;
    }

    public DiGraph(int V){
        this.V = V;
        adj = new List[V];
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    DiGraph reverse(){
        DiGraph g = new DiGraph(V);
        for(int i=0;i< V;i++){
            for(int w: adj(i)){
                g.addEdge(w,i);
            }
        }
        return g;
    }
}

package ch4;

import java.util.ArrayList;
import java.util.List;

public class DirectedEdgeWeightedGraph {
    private int V;
    private int E;
    private List<DirectedEdge> adj[];
    private List<DirectedEdge> edges;
    public DirectedEdgeWeightedGraph(int v){
        this.V = v;
        adj = new List[v];
        E = 0;
        edges = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public List<DirectedEdge> edges(){
        return edges;
    }

    public void addEdge(DirectedEdge edge){
        int from = edge.from();
        adj[from].add(edge);
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }
}

package ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * Minmium Spanning Tree
 */
public class EdgeWeightedGraph {
    private int V;
    private int E;
    private List<Edge> adj[];
    private List<Edge> edges;
    public EdgeWeightedGraph(int v){
        this.V = v;
        adj = new List[v];
        E = 0;
        edges = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public List<Edge> edges(){
        return edges;
    }

    public void addEdge(Edge edge){
        int either = edge.either();
        int other = edge.other(either);
        adj[either].add(edge);
        adj[other].add(edge);
        E++;
        edges.add(edge);
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }
}

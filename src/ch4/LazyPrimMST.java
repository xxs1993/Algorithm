package ch4;

import ch2.MinQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Minmium Spanning Tree
 */
public class LazyPrimMST {
    private boolean[] marked;
    private MinQueue<Edge> minQueue ;
    private Queue<Edge> edges = new PriorityQueue<>();
    public LazyPrimMST(EdgeWeightedGraph g){
        minQueue = new MinQueue<>(g.E());
        marked = new boolean[g.V()];
        visit(g,0);
        while (edges.size()<g.E()-1 && !minQueue.isEmpty()){
            Edge edge = minQueue.removeMin();
            int either = edge.either();
            int other = edge.other(either);
            if(marked[either]&&marked[other])continue;
            edges.add(edge);
            if(marked[either]) visit(g,other);
            else  visit(g,either);
        }
    }

    public Iterable<Edge> edges(){
        return edges;
    }

    private void visit(EdgeWeightedGraph g, int v){
        marked[v] = true;
        for(Edge e : g.adj(v)){
           if(!marked[e.other(v)]){
               minQueue.insert(e);
           }

        }
    }
}

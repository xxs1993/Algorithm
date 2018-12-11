package ch4;

import ch1.WeightedQuickUnion;
import ch2.BinaryHeap;
import ch2.MinQueue;

import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Minmium Spanning Tree K
 */
public class KruskalMST {
    private Queue<Edge> edges = new PriorityQueue<>();
   public KruskalMST(EdgeWeightedGraph g){
       MinQueue<Edge> queue = new MinQueue<>(g.E());
       WeightedQuickUnion union = new WeightedQuickUnion(g.V());
       for(Edge edge :g.edges()){
           queue.insert(edge);
       }
       while (!queue.isEmpty()&&edges.size()<g.V()-1) {
           Edge edge = queue.removeMin();
           int either = edge.either();
           int other  = edge.other(either);
           if(union.connected(either,other))continue;
           union.union(either,other);
           edges.add(edge);
       }

   }

   public Iterable<Edge> edges(){
       return edges;
   }
}

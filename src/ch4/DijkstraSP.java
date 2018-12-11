package ch4;

import java.util.Stack;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;

    private int s;

    private double distanceTo[];

    private IndexMinPQ<Double> indexMinPQ;

    public double distanceTo(int v){
        return distanceTo[v];
    }

    public DijkstraSP(DirectedEdgeWeightedGraph g, int s){
        this.s = s;
        edgeTo = new DirectedEdge[g.E()];
        distanceTo  = new double[g.E()];
        indexMinPQ = new IndexMinPQ<>(g.V());
        for(int i =0;i<g.E();i++){
            distanceTo[i] = Double.POSITIVE_INFINITY;
        }
        distanceTo[s] = 0;
        indexMinPQ.insert(s,0.0);
        while (!indexMinPQ.isEmpty()){
            int v = indexMinPQ.delMin();
            for(DirectedEdge w : g.adj(v)){
                relax(w);
            }
        }

    }

    public Iterable<DirectedEdge> pathTo(int v){
        Stack<DirectedEdge> stack = new Stack<>();
        for(DirectedEdge i = edgeTo[v];i!=null;i =edgeTo[i.from()]){
            stack.push(i);
        }
        return stack;
    }

    public void relax(DirectedEdge edge){
        int from = edge.from();
        int to  = edge.to();
        if(distanceTo[from]+edge.weight()<distanceTo[to]){
            edgeTo[to] = edge;
            distanceTo[to] = distanceTo[from]+edge.weight();
            if(indexMinPQ.contains(to)) indexMinPQ.decreaseKey(to,distanceTo[to]);
            else indexMinPQ.insert(to,distanceTo[to]);
        }
    }
}

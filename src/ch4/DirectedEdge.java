package ch4;

/**
 * Shortest Path
 */
public class DirectedEdge {
    private int from;
    private int to;
    private double weight;
    public DirectedEdge(int v,int w,double weight){
        from = v;
        to = w;
        this.weight = weight;
    }

    public int from(){
        return from;
    }

    public int to(){
        return to;
    }

    public double weight(){
        return weight;
    }
}

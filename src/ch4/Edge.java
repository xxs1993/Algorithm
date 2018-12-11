package ch4;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;
    public Edge(int v ,int w ,double weight){
        this.v =v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }
    public int other(int s){
        if(s == v){
            return w;
        }
        return v;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge e){
        if(this.weight>e.weight) return 1;
        else if(this.weight<e.weight) return -1;
        return 0;
    }
}

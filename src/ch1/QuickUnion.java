package ch1;

public class QuickUnion {
    private int[] prnt;
    public QuickUnion(int N){
        this.prnt = new int[N];
        for(int i=0;i<N;i++){
            this.prnt[i] = i;
        }
    }

    public int find(int p){
        int parent = prnt[p];
        while (parent!=p){
            parent = prnt[p];
        }
        return parent;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pparent = find(p);
        int qparent = find(q);
        prnt[qparent] = pparent;
    }
}

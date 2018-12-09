package ch1;

public class WeightedQuickUnion {
    private int[] prnt;
    private int[] size;
    public WeightedQuickUnion(int N){
        this.prnt = new int[N];
        this.size = new int[N];
        for(int i=0;i<N;i++){
            this.prnt[i] = i;
            this.size[i] = 1;
        }
    }

    public int pathCompressionFind(int p){
        while (prnt[p]!=p){
            prnt[p] = prnt[prnt[p]];
            p = prnt[p];
        }
        return p;
    }
    public int find(int p){
        while (prnt[p]!=p){
            p = prnt[p];
        }
        return p;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i==j) return;
        if(size[i]>=size[j]){
            size[i] = size[i] + size[j];
            prnt[j] = i;
        }else {
            size[j] = size[i] + size[j];
            prnt[i] = j;
        }
    }
}

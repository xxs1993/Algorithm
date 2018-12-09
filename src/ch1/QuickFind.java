package ch1;

public class QuickFind {
    private int[] id;
    private int N;
    public QuickFind(int N){
        id = new int[N];
        for(int i = 0;i<N;i++){
            id[i] = i;
        }
        this.N = N;
    }

    public int find(int i){
        return id[i];
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        for(int i =0;i<id.length;i++){
            if(id[i] == rootQ){
                id[i] = rootP;
            }
        }
    }
}

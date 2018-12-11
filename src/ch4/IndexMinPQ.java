package ch4;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private Key[] keys;
    private int[] pq;
    private int[]qp;
    private int N =0;
    public IndexMinPQ(int N){
        keys = (Key[]) new DirectedEdge[N+1];
        pq = new int[N+1];
        qp = new int[N+1];
        for(int i=0;i<N+1;i++){
            pq[i]  = -1;
        }

    }
    public void insert(int i, Key key){
        if(contains(i)){
            decreaseKey(i,key);
            return;
        }
        pq[++N] = i;
        qp[N-1] = N;
        keys[N-1] = key;
        swim(N);
    }

    private void swap(int i,int j){
        int pqi = pq[i];
        int pqj = pq[j];
        Key temp = keys[pqi];
        keys[pqi] = keys[pqj];
        keys[pqj] =temp;

    }

    private boolean less(int i,int j){
     return keys[pq[i]].compareTo(keys[pq[j]])<0;
    }
    private void swim(int k){
        while (k>1 && less(k,k/2)){
            swap(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            if(j<N && !less(j,j+1))j++;
            if(less(k,j))continue;
            swap(k,j);
            k = j;
        }
    }
    public void decreaseKey(int i, Key key){
        if(key.compareTo(keys[i])>0) return;
        keys[i] = key;
        swim(qp[i]);
    }
    public boolean contains(int i) {
        for(int j=1;j<N+1;j++){
            if(pq[j] == i) return true;
        }
        return false;
    }
    public int delMin() {
        Key key = keys[pq[1]];
        swap(1,N--);
        return pq[1];

    }
    boolean isEmpty() {
        return N==0;
    }
    int size(){
        return N;
    }
}

package ch2;


public class BinaryHeap {
    public int[] a;
    private int N;
    public void insert(int n){
        a[++N] = n;
        swim(N);
    }
    public BinaryHeap(int[] a){
        N = a.length-1;
        this.a = a;
    }


    private  void swim(int k){
        while (k>1 && a[k]<a[k/2]){
            Helper.swap(a,k,k/2);
            k = k/2;
        }
    }

    public int removeMax(){
        int re = a[1];
        Helper.swap(a,1,N--);
        a[N+1] = 0;
        sink(1);

        return re;

    }

    private void sink(int k){
        while (2*k <=N){
            int j = 2*k;
            if(j<N &&a[j]<a[j+1]) j++;
            if(a[k]>=a[j]) break;
            Helper.swap(a,k,j);
             k = j;
        }
    }


}

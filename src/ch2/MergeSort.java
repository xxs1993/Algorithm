package ch2;

public class MergeSort {
    public static void sort(int[] a){
        int[] aux = new int[a.length];
        sort(0,a.length-1,a,aux);

    }

    private static void sort(int lo,int hi,int[] a,int aux[]){
        if(lo>=hi) return;
        int mid = (lo+hi)/2;
        sort(lo,mid,a,aux);
        sort(mid+1,hi,a,aux);
        if(a[mid]<a[mid+1]) return;
        merge(a,aux,mid,lo,hi);
    }

    public static void bottomUpSort(int a[]){
        int N = a.length;
        int aux[] = new int[N];
        for(int sz = 1;sz<N;sz = 2*sz){
            for(int lo = 0;lo< N-sz;lo+=2*sz){
                merge(a,aux,lo+sz-1,lo,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }

    private static void merge(int[] a,int[] aux,int mid,int lo,int hi){
        for(int i=lo;i<=hi;i++)
            aux[i] = a[i];
        int i = lo,j = mid+1;
        for(int k = lo;k<=hi;k++){
             if(i>mid) a[k] = aux[j++];
             else if(j>hi) a[k] = aux[i++];
             else if(aux[i] >aux[j]) a[k] = aux[j++];
             else a[k] = aux[i++];
        }
    }

}

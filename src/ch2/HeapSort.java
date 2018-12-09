package ch2;

public class HeapSort {

    public static void sort(int[] a){
        int N = a.length;
        for(int i =N/2;i>=1;i--){
            sink(i,a,N);
        }
        while (N>1){
            swap(a,1,N);
            sink(1,a,--N);
        }
    }

    private static void swap(int[] a,int i,int j){
        int temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }
    private static boolean less(int[]a,int i , int j){
        return a[i-1]-a[j-1]<0;
    }




    private static void sink(int k,int[] a,int N){
        while (2*k <=N){
            int j = 2*k;
            if(j<N &&less(a,j+1,j)) j++;
            if(less(a,k,j)) break;
            swap(a,k,j);
            k = j;
        }
    }
}

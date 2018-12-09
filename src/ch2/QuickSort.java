package ch2;

public class QuickSort {
    public static void sort(int[] a){
        sort(0,a.length-1,a);
    }

    private static void sort(int lo,int hi,int[] a){
        if(lo>=hi) return;
        int j = partition(hi,lo,a);
        sort(lo,j,a);
        sort(j+1,hi,a);
    }

    private static int partition(int hi,int lo,int[] a){
        int i = lo,j = hi+1;
        while (true){
            while (a[lo]>a[++i]){
                if(i==hi)break;
            }
            while (a[lo]<a[--j]){
                if(j == lo) break;
            }
            if(i>=j) break;
            Helper.swap(a,i,j);
        }
        Helper.swap(a,lo,j);
        return j;
    }

    public static int select(int[] a,int k){
         int lo = 0,hi = a.length-1;
         while (lo<hi){
             int j = partition(hi,lo,a);
             if(j<k) lo = j+1;
             else if(j>k)hi = j-1;
             else return a[k];
         }
         return a[k];
    }

    public static void threeWaySort(int[] a){
        threeWaySort(a.length-1,0,a);
    }

    private static void threeWaySort(int hi,int lo,int[] a){
        if(lo>=hi) return;
        int lt = lo,gt = hi,i = lo;
        int v = a[lo];
        while (i<=gt){
            if(a[i]<v) {
                Helper.swap(a,i++,lt++);
            }else if(a[i]>v){
                Helper.swap(a,i,gt);
                gt--;
            }else i++;
        }
        threeWaySort(lt-1,0,a);
        threeWaySort(hi,gt+1,a);
    }
}

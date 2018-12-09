package ch2;

public class ShellSort {
    public static void sort(int[] a){
        int h = 1;
        int N = a.length;
        while (h<N/3) h = 3*h+1;
        while (h>=1){
            for(int i = 0;i<N;i++){
                for(int j=i;j>=h && a[j]<a[j-h];j = j-h){
                    Helper.swap(a,j,j-h);
                }
            }
            h = h/3;
        }
    }
}

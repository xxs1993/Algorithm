package ch2;

public class SelectionSort {
    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            int min = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j] < a[i]){
                    min = j;
                }
            }
            Helper.swap(a,min,i);
        }
    }
}

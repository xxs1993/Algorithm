package ch2;

public class InsertionSort {
    public static void sort(int [] a){
        for(int i =0;i<a.length;i++){
            for(int j =i;j>0;j--){
                if(a[j]>=a[j-1]){
                    break;
                }
                Helper.swap(a,j-1,j);
            }
        }
    }
}

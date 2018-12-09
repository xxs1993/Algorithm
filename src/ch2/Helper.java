package ch2;

import java.util.Random;

public class Helper {

    public static void swap(int[] a, int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void knuthShuffle(int[] a){
        Random r = new Random();
        for(int i = 0;i<a.length;i++){
            int index = r.nextInt(i+1);
            swap(a,index,i);
        }
    }
}

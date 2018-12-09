package ch2;

import ch1.QuickUnion;

import java.util.Arrays;

public class Driver {
    public static void main (String args[]){
        int[] a = new int[8];
        a[0] = 4;
        a[1] = 3;
        a[2] = 2;
        a[4] = 6;
        a[5] = 4;
        a[6]=4;
        int b[] = new int[5];
        b[0] = 1;
        b[1] = 4;
        b[2] = 2;
        b[3]=3;
        b[4] = 5;
//        int i = QuickSort.select(a,4);
//        System.out.println(i);
        HeapSort.sort(b);

        QuickSort.threeWaySort(a);
//        Helper.knuthShuffle(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
}

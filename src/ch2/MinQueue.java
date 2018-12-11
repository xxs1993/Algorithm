package ch2;

import ch4.Edge;

import java.util.Comparator;

public class MinQueue<Key extends Comparable<Key>> {
    private Key[] array;
    private int N;
    public MinQueue(int n){
        this.N = 0;
        array = (Key[])new Edge[n*2];
    }

    public boolean isEmpty(){
        return N==0;
    }

    private void swap(int i,int j){
       Key temp =  array[i] ;
       array[i] = array[j];
       array[j] = temp;
    }

    public void insert(Key key){
        array[++N] = key;
        swim(N);
    }
    public Key removeMin(){
        Key key = array[1];
        swap(1,N--);
        sink(1);
        return key;
    }

    private void swim(int k){
        while (k>1){
            if(array[k].compareTo(array[k/2])>=0) break;
            swap(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            if(j<N&&array[j].compareTo(array[j+1])>0)j++;
            if(array[k].compareTo(array[j])<=0) break;
            swap(k,j);
            k = j;
        }
    }
}

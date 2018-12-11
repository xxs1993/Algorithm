package ch4;

import java.util.PriorityQueue;
import java.util.Queue;

public class Demo {
    private boolean[] marked;
    private int[] edgeTo ;
    private int[] distanceTo;
    private int s;
    public Demo(Graph g,int s){
        int v = g.V();
        marked = new boolean[v];
        edgeTo = new int[v];
        distanceTo = new int[v];
        this.s = s;
    }
    public void bfs(Graph g,int s){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(s);
        marked[s] = true;
        distanceTo[s] = 0;
        while (!queue.isEmpty()){
            int v = queue.poll();
            for(int w : g.adj(v)){
                if(marked[w]){
                    continue;
                }
                queue.add(w);
                distanceTo[w] = 1+distanceTo[v];
                marked[w] = true;
                edgeTo[w] = v;
            }
        }
    }
}

package ch4;

import sun.misc.Queue;

import java.util.Stack;

public class BreadthFirstSearch {
    private boolean[] marked;

    private int[] edgeTo;

    private int[] distance;

    private int s;

    public BreadthFirstSearch(Graph g,int s){
        this.s = s;
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        this.distance = new int[g.V()];
        bfs(g,s);
    }

    private void bfs(Graph g, int v){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        marked[v] =true;
        distance[v] = 0;
        try {
            while (!queue.isEmpty()) {
                int w = queue.dequeue();
                for(int i : g.adj(w)){
                    if(marked[i]){
                        continue;
                    }
                    queue.enqueue(i);
                    marked[i] = true;
                    edgeTo[i] = w;
                    distance[i] = distance[w] +1;
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for(int w  = v; w!=s;w = edgeTo[w]){
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
}

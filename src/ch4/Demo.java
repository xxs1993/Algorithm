package ch4;


import sun.misc.Queue;

import java.util.Stack;

public class Demo {
    private boolean[] marked;
    private int V;
    private int s;
    private int[] edgeTo;
    public Demo(Graph g,int s){
        this.V = g.V();
        this.s = s;
        marked = new boolean[this.V];
        dfs(g,s);
    }

    private void dfs(Graph g,int s){
        marked[s] = true;
        for(int i : g.adj(s)){
            if(!marked[i]){
                dfs(g,i);
                edgeTo[i] =s;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> queue = new Stack<>();
        queue.push(v);
        while (v!=s){
            queue.push(edgeTo[v]);
            v = edgeTo[v];
        }
        queue.push(v);
        return queue;
    }
}

package ch4;

import java.util.Stack;

public class DepthFirstSearch {
    private int s ;

    private boolean[] marked;

    int[] edgeTo;


   public DepthFirstSearch(Graph g, int s){
       this.s = s;
       marked = new boolean[g.V()];
       edgeTo = new int[g.V()];
       dfs(g,s);
   }

   private void dfs(Graph g, int v){
       marked[v] = true;
       for(int w : g.adj(v)){
           if(!marked[w]){
               dfs(g,w);
               edgeTo[w] = v;
           }
       }
   }

   public boolean hasPathTo(int v){
       return marked[v];
   }

   public Iterable<Integer> pathTo(int v){
       if(!hasPathTo(v)) return null;
       Stack<Integer> stack = new Stack<>();
       for(int i = v;i!=s;i = edgeTo[i])
           stack.push(i);
       stack.push(s);
       return stack;
   }
}

package ch4;

import java.util.Stack;

/**
 * topological
 */
public class DepthFirstOrder {
    private boolean marked[];
    private Stack<Integer> reverseOrder;
    public DepthFirstOrder(DiGraph g){
        this.marked = new boolean[g.V()];
        reverseOrder = new Stack<>();
        for(int i = 0;i< g.V();i++){
            if(!marked[i])
                dfs(g,i);
        }
    }

    private void dfs(DiGraph g,int v){
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
        reverseOrder.push(v);
    }

    public Iterable<Integer> reverseOrder(){
        return reverseOrder;
    }
}

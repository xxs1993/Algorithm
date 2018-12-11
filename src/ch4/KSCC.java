package ch4;

import java.util.Stack;

/**
 * Strong connected Component
 */
public class KSCC {
    private boolean marked[];

    public int[] id;

    public int count;

    public KSCC(DiGraph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        DepthFirstOrder order = new DepthFirstOrder(g.reverse());
        Stack<Integer> reverseOrder = (Stack<Integer>) order.reverseOrder();
        for(int w = reverseOrder.pop();!reverseOrder.isEmpty();w=reverseOrder.pop()){
            if(!marked[w]){
                dfs(g,w);
                count++;
            }
        }
    }

    private void dfs(DiGraph g, int v){
        marked[v] = true;
        id[v] = count;
        for(int w : g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }
}

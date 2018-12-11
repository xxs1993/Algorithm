package ch4;

/**
 * DFS for Digraph
 */
public class DFSDigraph {
    private boolean marked[];
    private int edgeTo[];
    private int s;
    public DFSDigraph(DiGraph g,int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g,s);
    }

    private void dfs(DiGraph g, int v){
        marked[v] = true;
        for(int i: g.adj(v)){
            if(marked[v]){
                continue;
            }
            dfs(g,i);
            edgeTo[i] = v;
        }
    }
}

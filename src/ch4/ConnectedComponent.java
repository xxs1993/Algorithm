package ch4;

public class ConnectedComponent {
    private boolean[] marked;

    private int[] id;

    private int count;
    public ConnectedComponent(Graph graph){
        int v = graph.V();
        marked = new boolean[v];
        id = new int[v];
        for(int i=0;i<v;i++){
            if(marked[i]){
                continue;
            }
            dfs(graph,i);
            count++;
        }
    }

    public boolean connected(int v,int w){
        return id[v] == id[w];
    }

    private void dfs(Graph graph , int s){
        id[s] = count;
        marked[s] = true;
        for(int w : graph.adj(s)){
            if(!marked[w]){
                dfs(graph,w);
            }
        }
    }
}

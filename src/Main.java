import ch4.BreadthFirstSearch;
import ch4.DepthFirstSearch;
import ch4.Graph;

public class Main {
    public static void main(String args[]){
        Graph graph = new Graph(11);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(3,5);
        graph.addEdge(6,7);
        graph.addEdge(5,8);
        graph.addEdge(8,10);
        graph.addEdge(9,10);
        graph.addEdge(10,7);
        DepthFirstSearch dfs = new DepthFirstSearch(graph,0);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph,0);
        System.out.println("dfs");
        for(int i : dfs.pathTo(10)){
            System.out.print(i +" , ");
        }
        System.out.println("bfs");
        for(int i : bfs.pathTo(10)){
            System.out.print(i +" , ");
        }
    }


    private Node put(Node x,Key key,Value value,boolean color){
        if(x == null) return new Node(key,value,color);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left,key,value,color);
        else if(cmp > 0) x.right = put(x.right,key,value,color);
        else {

        }
    }
}

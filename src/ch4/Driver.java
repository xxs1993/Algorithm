package ch4;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Driver {
    public static void main(String[] args){

       kruskalMST();
    }

    private static void kscc(){
        DiGraph graph = new DiGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(3,4);
        graph.addEdge(1,5);
        graph.addEdge(2,4);
        graph.addEdge(5,0);
        graph.addEdge(4,3);
        KSCC kscc =  new KSCC(graph);
        System.out.println(Arrays.toString(kscc.id));
    }

    private static void kruskalMST(){
        int N = 10;
        EdgeWeightedGraph g = new EdgeWeightedGraph(N);
        Random r = new Random();
        for(int i =0;i<15;i++){
            Edge edge = new Edge(r.nextInt(N),r.nextInt(N),Math.random());
            g.addEdge(edge);
        }
        for(Edge edge : g.edges()){
            System.out.println(edge);
        }
        System.out.println("MST");
        KruskalMST mst = new KruskalMST(g);
        for(Edge e : mst.edges()){
            System.out.println(e);
        }
        System.out.println("Prim MST ");
        LazyPrimMST lmst = new LazyPrimMST(g);

        for(Edge e : lmst.edges()){
            System.out.println(e);
        }
    }

    private static void digraph(){
        DiGraph graph = new DiGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(2,4);
        graph.addEdge(5,0);
        graph.addEdge(4,3);
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        Stack<Integer> stack = (Stack<Integer>) depthFirstOrder.reverseOrder();
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

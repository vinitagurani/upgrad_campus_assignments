import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)  {
        //------------------------implementing graph-----------------------------------------------------------------

        MyGraph <Integer> graph = new AdjacencyList<>();
        Node <Integer> n1 = graph.addNode(1);
        Node <Integer> n2 = graph.addNode(2);
        Node <Integer> n3 = graph.addNode(3);
        Node <Integer> n4 = graph.addNode(4);
        Node <Integer> n5 = graph.addNode(5);
        Node <Integer> n6 = graph.addNode(6);
        try {
            graph.addEdge(n1,n2);
            graph.addEdge(n1,n3);
            graph.addEdge(n1,n4);
            graph.addEdge(n1,n5);
            graph.addEdge(n2,n4);
            graph.addEdge(n4,n5);
            //graph.addEdge(n5,n6);
            //-------------------1. dfs-------------------------------------------------------------
            Map<Node<Integer>, Integer> dfs_nums = dfs (graph, n2);
            for (Node<Integer> n : dfs_nums.keySet()) {
                System.out.println (n+" : "+dfs_nums.get(n));
            }
            //-------------------2. all nodes connected or not in a graph----------------------------
            Set<Node<Integer>> reachable = dfsConnected(graph, n2);
            for (Node<Integer> n: reachable) {
                System.out.println (n);
            }
            //-------------------3. bfs--------------------------------------------------------------
            Map <Node<Integer>, Integer> levels = bfs(graph, n2);
            for (Node<Integer> n : levels.keySet()) {
                System.out.println (n+" : "+levels.get(n));
            }
        }
        catch (Exception e){
            System.out.println (e.getMessage());
            System.exit(1);
        }

        //---------------------4. shortest path-------------------------------------------------------
        MyGraph2 <String> graph2 = new AdjacencyList2<String> ();
        Node <String> c1 = graph2.addNode("c1");
        Node <String> c2 = graph2.addNode("c2");
        Node <String> c3 = graph2.addNode("c3");
        Node <String> c4 = graph2.addNode("c4");
        Node <String> c5 = graph2.addNode("c5");

        try {
            graph2.addEdge(c2, c1, 20);
            graph2.addEdge(c1, c3, 50);
            graph2.addEdge(c3, c4, 70);
            graph2.addEdge(c4, c2, 100);
            graph2.addEdge(c1, c4, 200);
            graph2.addEdge(c3, c5, 10);
            graph2.addEdge(c5, c4, 20);

            Map<Node<String>, Integer> paths = shortestPath(graph2, c2); // from c2 to

            for (Node<String> n : paths.keySet()) {
                if(n == c3) { // from c2 to c3
                    System.out.println(n + " : " + paths.get(n));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
      //--------------------------------question numbers from 5 onwards in the end-----------------------------------------------------------------
    }
    public static Map <Node<String>, Integer> shortestPath (MyGraph2<String> graph, Node<String> start) throws Exception {
        Map<Node<String>, Integer> distances = new HashMap <>();
        int max = maximumDistance (graph);
        for (Node<String> node: graph.getAllNodes()) {
            distances.put(node,max);
        }
        distances.put(start,0);
        Node<String> nextNode = start;
        for (Edge2<String> edge: graph.getAllOutGoingEdges(nextNode)) {
            relax (edge, distances);
        }
        PriorityQueue<Node<String>> queue = new PriorityQueue<Node<String>>(new MyComparator<Node<String>> (distances));
        for (Node<String> n: graph.getAllNodes()) {
            queue.add(n);
        }
        while (!queue.isEmpty()) {
            Node <String> dequeued = queue.poll();
            nextNode = queue.peek();
            if (nextNode != null) {
                for (Edge2<String> edge: graph.getAllOutGoingEdges(nextNode)) {
                    relax (edge, distances);
                }
            }
        }
        return distances;
    }
    public static int maximumDistance(MyGraph2<String> graph) {
        int sum = 0;
        for (Edge2 <String> e: graph.getAlledges()) {
            sum+= e.weight;
        }
        return sum+1;
    }
    static class MyComparator <T extends Node<String>> implements Comparator<T> {
        private final Map<Node<String> , Integer> distances;

        MyComparator(Map<Node<String>, Integer> distances) {
            this.distances = distances;
        }
        @Override
        public int compare(T n1, T n2) {
            if (this.distances.get(n1) < this.distances.get(n1)) {
                return -1;
            }
            else if (this.distances.get(n1) > this.distances.get(n1))
                return 1;
            else
                return 0;
        }
    }
    public static void relax (Edge2<String> edge, Map<Node<String>, Integer> distances) {
        int possible = distances.get (edge.n1)+edge.weight;
        if (distances.get(edge.n2) > possible)
            distances.put(edge.n2, possible);
    }
    public static Map<Node<Integer>, Integer> bfs (MyGraph<Integer> graph, Node<Integer> node) throws Exception {
        Queue<Node<Integer>> q = new LinkedList<>();
        Map<Node<Integer>, Integer> levels = new HashMap<>();
        Set<Map.Entry<Node<Integer>, Integer>> s = levels.entrySet();
        
        q.add(node);
        levels.put (node, 0);
        while (!q.isEmpty()) {
            Node<Integer> nextNode = q.remove ();
            Set<Node<Integer>> neighbors = graph.getAllNeighbors(nextNode);
            for (Node<Integer> n: neighbors) {
                if (!levels.containsKey(n)) {
                    levels.put(n, levels.get(nextNode) + 1);
                    q.add(n);
                }
            }
        }
        return levels;
     }
    public static Set<Node<Integer>> dfsConnected (MyGraph<Integer> graph, Node<Integer> node) throws Exception {
        Set <Node<Integer>> reachable = new HashSet<>();
        dfsConnected_rec (graph, node, reachable);
        return reachable;
    }
    public static void dfsConnected_rec (MyGraph<Integer> graph, Node<Integer> node, Set<Node<Integer>> reachable) throws Exception {
        if (reachable.contains(node))
            return;
        reachable.add(node);
        for (Node<Integer> n: graph.getAllNeighbors(node)) {
            dfsConnected_rec(graph, n, reachable);
        }
    }
    public static Map <Node<Integer>, Integer>dfs (MyGraph<Integer> graph, Node <Integer> n) throws Exception {
        Map<Node<Integer>, Integer> dfs_nums = new HashMap<>();
        dfs_rec(graph, n, dfs_nums);
        return dfs_nums;
    }
    public static void dfs_rec (MyGraph<Integer> graph, Node <Integer> node, Map<Node<Integer>, Integer>dfs_nums) throws Exception {
        if (dfs_nums.containsKey(node))
            return;
        dfs_nums.put(node, dfs_nums.size()+1);
        for (Node<Integer> neigh: graph.getAllNeighbors(node)) {
            dfs_rec(graph, neigh, dfs_nums);
        }
    }
    private int V;
    private LinkedList <Integer> list[];
    Main (int v) {
        V= v;
        list = new LinkedList[v];
        for (int i = 0;i< list.length;i++ ) {
            list[i] = new LinkedList<>();
        }
    }
    void addEdge (int v, int w) {
        list[v].add(w);
    }

    void bfs (int s) {
        boolean visited[] = new boolean [V];
        LinkedList <Integer> queue = new LinkedList <>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
             s = queue.poll();
            System.out.print (s+" ");
            Iterator <Integer> i = list[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
    }
}
//----------------------------------------------5.  implementing graph by edge list---------------------------------------------------------------------------------

public class Edge <T> {
    public final Node <T> n1; // undirected graph
    public final Node <T> n2;

    public Edge (Node <T> n1, Node <T> n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
    public Boolean equals (Edge <T> e) {
        return (this.n1.equals(e.n1) && this.n2.equals(e.n2))
                ||(this.n1.equals(e.n2) && this.n2.equals(n1));
    }


}

import java.util.HashSet;
import java.util.Set;

public class EdgeList <T> implements MyGraph<T> {
    Set <Node<T>> nodes = new HashSet<>();
    Set <Edge<T>> edges = new HashSet<>();

    @Override
    public Set<Node<T>> getAllNodes() {
        return this.nodes;
    } //O(n)

    @Override
    public Node<T> addNode(T e) { // O(n)
        Node<T> newNode = new Node<T> (e);
        nodes.add(newNode);
        return newNode;
    }

    @Override
    public Edge<T> addEdge(Node<T> n1, Node<T> n2) throws Exception { //O(1)
        if (!this.nodes.contains(n1) || !this.nodes.contains(n2))
            throw new Exception ("At least one of the nodes in not present in the graph");
        Edge <T> edge = new Edge (n1,n2);
        this.edges.add(edge);
        return edge;
    }

    @Override
    public Set<Node<T>> getAllNeighbors(Node<T> n) throws Exception { //O(E)
        if (!this.nodes.contains(n))
            throw new Exception("Node is not present in the graph");
        Set <Node<T>> neighbours = new HashSet<>();
        for (Edge<T> edge: this.edges) {
            if (edge.n1.equals(n))
                neighbours.add(n);
            else if (edge.n2.equals(n))
                neighbours.add(n);
        }
        return neighbours;
    }
}

//----------------------------------------------------6. Adjacency list (Undirected, unweighted graphs)-------------------------------------------------

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdjacencyList <T> implements MyGraph<T> {
    Map<Node<T>, Set<Node<T>>> adjacencyList = new HashMap<>();


    @Override
    public Set<Node<T>> getAllNodes() {
        return this.adjacencyList.keySet();
    }

    @Override
    public Node<T> addNode(T e) {
        Node <T> newNode = new Node (e);
        adjacencyList.put (newNode, new HashSet<>());
        return newNode;
    }

    @Override
    public Edge<T> addEdge(Node<T> n1, Node<T> n2) throws Exception {
        if (!this.adjacencyList.containsKey(n1) || !this.adjacencyList.containsKey(n2))
            throw new Exception ("At least one of the nodes in not present in the graph");
        this.adjacencyList.get(n1).add(n2);
        this.adjacencyList.get(n2).add(n1);
        return new Edge<T>(n1,n2);
    }

    @Override
    public Set<Node<T>> getAllNeighbors(Node<T> n) throws Exception {
        if (!this.adjacencyList.containsKey(n))
            throw new Exception("Node is not present in the graph");
        return this.adjacencyList.get(n);
    }
}

//---------------------------------------------------------7. Adjacency Matrix -------------------------------------------------------------------

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencyMatrix<T> implements MyGraph<T>{
    List<Node<T>> nodes = new ArrayList<>();
    boolean [][] adjacencyMatrix = new boolean [0][0];
    @Override
    public Set<Node<T>> getAllNodes() { // T(n) = O(n)
        Set <Node<T>> set = new HashSet<>();
        for (Node<T> n:nodes) {
            set.add(n);
        }
        return set;
    }

    @Override
    public Node<T> addNode(T e) {
        //T(n) = O(n^2)
        Node<T> newNode = new Node(e);
        nodes.add(newNode);
        boolean[][] m = new boolean[this.nodes.size()][this.nodes.size()];
        for (int i = 0;i< m.length;i++) {
            for (int j = 0;j< m.length;j++) {
                m[i][j] = false;
            }
        }
        for (int i = 0;i< adjacencyMatrix.length;i++) {
            for (int j = 0;j< adjacencyMatrix.length;j++) {
                m[i][j] = adjacencyMatrix[i][j];
            }
        }
        this.adjacencyMatrix = m;
        return newNode;
    }

    @Override
    public Edge<T> addEdge(Node<T> n1, Node<T> n2) throws Exception { // T(n)= O(n)
        if (!this.nodes.contains(n1) || !this.nodes.contains(n2))
            throw new Exception ("At least one of the nodes is not present in the graph");
        int row = this.nodes.indexOf(n1);
        int col = this.nodes.indexOf(n2);
        adjacencyMatrix[row][col] = true;
        adjacencyMatrix[col][row] = true;
        return new Edge<T> (n1,n2);
    }

    @Override
    public Set<Node<T>> getAllNeighbors(Node<T> n) throws Exception { // T(n) = O(n) n = number of nodes
        if (!this.nodes.contains(n))
            throw new Exception("Node is not present in the graph");
        Set <Node<T>> neighbors = new HashSet <Node<T>>();
        int row = this.nodes.indexOf(n);
        for (int i = 0;i< adjacencyMatrix.length;i++) {
            if (adjacencyMatrix[row][i])
                neighbors.add(this.nodes.get(i));
        }
        return neighbors;
    }
}

 

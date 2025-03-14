package leetcodeZoho5_dp;

import java.util.*;

public class GraphAdjacency {
    private Map<Integer, List<Integer>> adjList;

    public GraphAdjacency() {
        adjList = new HashMap<>();
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        //equal to above inbuilt function
//        if (!adjList.containsKey(u)) {
//            adjList.put(u, new ArrayList<>()); // Initialize the list if key is not present
//        }
//        adjList.get(u).add(v); 
        
        //adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println("Node " + entry.getKey() + " is connected to: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        GraphAdjacency graph = new GraphAdjacency();

//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 5);
        
        graph.addEdge(1, 2);
        graph.addEdge(3,7);
        graph.addEdge(7,10);
        graph.addEdge(3,4);
        graph.addEdge(3,6);
        graph.addEdge(4,3);
        graph.addEdge(1,8);
        graph.addEdge(5,6);
        graph.addEdge(6,2);
        graph.addEdge(2,4);

        graph.printGraph();
    }
}

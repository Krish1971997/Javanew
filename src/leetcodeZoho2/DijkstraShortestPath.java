package leetcodeZoho2;

import java.util.*;

public class DijkstraShortestPath {

	private static class Edge {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static int[] dijkstra(List<List<Edge>> graph, int source) {
		int numVertices = graph.size();
		int[] distances = new int[numVertices];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[source] = 0;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> distances[v]));
		minHeap.offer(source);

		while (!minHeap.isEmpty()) {
			int u = minHeap.poll();

			for (Edge edge : graph.get(u)) {
				int v = edge.to;
				int weight = edge.weight;

				if (distances[u] + weight < distances[v]) {
					distances[v] = distances[u] + weight;
					minHeap.offer(v);
				}
			}
		}
		return distances;
	}

	public static void main(String[] args) {
		int numVertices = 5; // Number of vertices in the graph
		int source = 0; // Source vertex

		// Example graph represented using adjacency lists
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			graph.add(new ArrayList<>());
		}

		// Adding edges to the graph (vertex, weight)
		graph.get(0).add(new Edge(1, 9));
		graph.get(0).add(new Edge(2, 6));
		graph.get(0).add(new Edge(3, 5));
		graph.get(0).add(new Edge(4, 3));

		graph.get(2).add(new Edge(1, 2));
		graph.get(2).add(new Edge(3, 4));

		// Run Dijkstra's algorithm from the source vertex
		int[] distances = dijkstra(graph, source);

		// Output the shortest distances from the source vertex
		System.out.println("Shortest distances from vertex " + source + ":");
		for (int i = 0; i < numVertices; i++) {
			System.out.println("To vertex " + i + ": " + distances[i]);
		}
	}
}

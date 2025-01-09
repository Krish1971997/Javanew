package leetcodeZoho2;

import java.util.*;

public class DijkstraAlgorithm {
	private static final int NO_EDGE = 0;

	private static int findMinDistance(int[] distances, boolean[] visited) {
		int minDistance = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < distances.length; i++) {
			if (!visited[i] && distances[i] < minDistance) {
				minDistance = distances[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void dijkstra(int[][] graph, int source) {
		int vertices = graph.length;
		int[] distances = new int[vertices];
		boolean[] visited = new boolean[vertices];

		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[source] = 0;

		for (int i = 0; i < vertices - 1; i++) {
			int u = findMinDistance(distances, visited);
			visited[u] = true;

			for (int v = 0; v < vertices; v++) {
				if (!visited[v] && graph[u][v] != NO_EDGE && distances[u] != Integer.MAX_VALUE
						&& distances[u] + graph[u][v] < distances[v]) {
					distances[v] = distances[u] + graph[u][v];
				}
			}
		}

		printSolution(distances, source);
	}

	private static void printSolution(int[] distances, int source) {
		System.out.println("Shortest distances from source (A):");
		char vertex = 'A';
		for (int i = 0; i < distances.length; i++) {
			System.out.println(vertex++ + " -> " + distances[i]);
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 10, 15, 0, 0, 0 }, 
						  { 0, 0, 0, 12, 0, 15 }, 
						  { 0, 0, 0, 10, 0, 0 }, 
						  { 0, 0, 0, 0, 2, 1 },
						  { 0, 0, 0, 0, 0, 5 }, 
						  { 0, 0, 0, 0, 0, 0 } };

		int source = 0; // Vertex A
		dijkstra(graph, source);
	}
}

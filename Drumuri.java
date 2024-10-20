import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Graph {
	private int V; // Number of vertices
	private List<int[]>[] adj; // Adjacency list to store graph edges
	private List<int[]>[] revAdj; // Reverse adjacency list for the reversed graph

	// Inner class to represent a pair of vertex and its weight
	class IPair implements Comparable<IPair> {
		int vertex;
		long weight;

		IPair(int v, long w) {
			vertex = v;
			weight = w;
		}

		// Comparison method for priority queue
		public int compareTo(IPair other) {
			return Long.compare(this.weight, other.weight);
		}
	}

	// Constructor to initialize the graph
	Graph(int V) {
		this.V = V;
		adj = new ArrayList[V];
		revAdj = new ArrayList[V];
		for (int i = 0; i < V; ++i) {
			adj[i] = new ArrayList<>();
			revAdj[i] = new ArrayList<>();
		}
	}

	// Method to add an edge to the graph
	void addEdge(int u, int v, int w) {
		adj[u].add(new int[]{v, w});
		revAdj[v].add(new int[]{u, w}); // Adding reverse edge for the reversed graph
	}

	// Method to get adjacency list
	public List<int[]>[] getAdj() {
		return adj;
	}

	// Method to get reverse adjacency list
	public List<int[]>[] getRevAdj() {
		return revAdj;
	}

	// Method to find the shortest paths from source vertex to all other vertices
	long[] shortestPath(int src, List<int[]>[] adjList) {
		PriorityQueue<IPair> pq = new PriorityQueue<>();
		long[] dist = new long[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new IPair(src, 0));
		dist[src] = 0;

		// Dijkstra's algorithm
		while (!pq.isEmpty()) {
			int u = pq.poll().vertex;

			for (int[] neighbor : adjList[u]) {
				int v = neighbor[0];
				long weight = neighbor[1];

				// Relaxation step
				if (dist[v] > dist[u] + weight) {
					dist[v] = dist[u] + weight;
					pq.add(new IPair(v, dist[v]));
				}
			}
		}
		return dist;
	}
}

public class Drumuri {
	static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("drumuri.in"));
			PrintWriter writer = new PrintWriter(new File("drumuri.out"))) {

			// reading the number of cities and the number of roads
			int n = sc.nextInt();
			int m = sc.nextInt();

			Graph graph = new Graph(n);

			// reading all roads and building the graph
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				int c = sc.nextInt();
				graph.addEdge(a, b, c);
			}

			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int z = sc.nextInt() - 1;

			// calculating shortest paths from x, y and to z
			long[] distFromX = graph.shortestPath(x, graph.getAdj());
			long[] distFromY = graph.shortestPath(y, graph.getAdj());
			long[] distToZ = graph.shortestPath(z, graph.getRevAdj());

			long result = INF;
			// iterating through all the nodes of the graph to find the minimum distance
			for (int i = 0; i < n; i++) {
				// checking if there are valid paths from x to i, y to i and i to z
				// if they are infinite, the path is not valid
				if (distFromX[i] != INF && distFromY[i] != INF && distToZ[i] != INF) {
					// if the sum of the distances is less than the current result
					// update the result
					if (distFromX[i] + distFromY[i] + distToZ[i] < result) {
						result = distFromX[i] + distFromY[i] + distToZ[i];
					}
				}
			}

			// write the result to the output file
			writer.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

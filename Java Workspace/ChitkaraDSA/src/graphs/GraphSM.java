package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class GraphImpl {
	HashMap<Integer, HashSet<Integer>> graph = new HashMap<>(); // Structure created

	void addVertex(int data) {
		if (graph.containsKey(data)) {
			System.out.println("Vertex " + data + " already exists.");
			return;
		}
		graph.put(data, new HashSet<>()); // Added a vertex.
	}

	void addEdge(int u, int v) {
		// u ke neighbors wale set mein v add krdenge
		graph.get(u).add(v); // One Direction
		// For bidirectional add vice versa also
	}

	void print() {
		for (Integer vertex : graph.keySet()) {
			System.out.print("Vertex " + vertex + ": ");
			System.out.println(graph.get(vertex)); // neighbor set of vertex
		}
	}
	
	void BFS(int s) // Start the BFS from the vertex s
	{
		System.out.println("------BFS------");
		HashSet<Integer> visited = new HashSet<>();// to store if the vertex has been already visited or not
		Queue<Integer> q = new LinkedList<>();

		q.add(s);
		visited.add(s);

		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");

			// add all the unvisited neighbors of node in the queue and mark them visited
			for (Integer x : graph.get(node)) // pick the neighbors of node one by one
			{
				if (!visited.contains(x)) // if neighbor is not visited
				{
					visited.add(x);
					q.add(x);
				}
			}
		}
		System.out.println();
		System.out.println("---------------");
	}
	
	void DFS(int s) {
		System.out.println("------DFS------");
		HashSet<Integer> visited = new HashSet<Integer>();
		DFSUtil(s, visited); // Utility/Helper Function -> To pass the same array to all recursive calls
		System.out.println();
		System.out.println("---------------");

	}

	void DFSUtil(int s, HashSet<Integer> visited) {
		System.out.print(s + " ");
		visited.add(s);
		for (Integer x : graph.get(s)) // pick neighbors of s one by one
		{
			if (!visited.contains(x)) // If x is an unvisited neighbor
			{
				DFSUtil(x, visited); // Do DFS on that neighbor
			}
		}
	}

	void DFSOverall() {
		System.out.println("------DFS Overall------");
		HashSet<Integer> visited = new HashSet<Integer>();
		int count = 0;
		for (Integer i: graph.keySet()) {
			if (!visited.contains(i)) {
				DFSUtil(i, visited); // Utility/Helper Function -> To pass the same array to all recursive calls
				System.out.println();
				count++;
			}
		}
		System.out.println("Total Connected Components: " + count);
		System.out.println("---------------");
	}
}

public class GraphSM {
	public static void main(String[] args) {
		GraphImpl g = new GraphImpl();
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(5, 6);
		
		g.print();
		
		g.BFS(0);
		g.BFS(2);
		
		g.DFS(0);
		
		g.DFSOverall();
	}

}

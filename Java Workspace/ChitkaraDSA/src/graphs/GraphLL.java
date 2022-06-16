package graphs;

import java.util.LinkedList;
import java.util.Queue;

class Graph {
	int v; // No. of vertices
//	int arr[] = new int[size];
//	String arr[] = new String[size];

	LinkedList<Integer> arr[];

	Graph(int v) {
		this.v = v;
		arr = new LinkedList[v]; // We've only created the array to store LinkedLists
		// as of now array has null at all the locations.

		for (int i = 0; i < v; i++) {
			arr[i] = new LinkedList<>(); // Initializing empty LL's at each array position
		}
	}

	void addEdge(int u, int v) // (u,v) -> An edge from u to v.
	{
		arr[u].add(v); // in the neighbor list of u, add v
		// arr[v].add(u); -> If we want our graph to be bidirectional
	}

	void print() {
		for (int i = 0; i < v; i++) {
			System.out.print("Neighbors of " + i + ": ");
			for (Integer x : arr[i]) // pick neighbors of i one by one from its neighbor list(arr[i])
			{
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	void BFS(int s) // Start the BFS from the vertex s
	{
		System.out.println("------BFS------");
		boolean visited[] = new boolean[v];// to store if the vertex has been already visited or not
		Queue<Integer> q = new LinkedList<>();

		q.add(s);
		visited[s] = true;

		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");

			// add all the unvisited neighbors of node in the queue and mark them visited
			for (Integer x : arr[node]) // pick the neighbors of node one by one
			{
				if (!visited[x]) // if neighbor is not visited
				{
					visited[x] = true;
					q.add(x);
				}
			}
		}
		System.out.println();
		System.out.println("---------------");
	}

	void DFS(int s) {
		System.out.println("------DFS------");
		boolean visited[] = new boolean[v];
		DFSUtil(s, visited); // Utility/Helper Function -> To pass the same array to all recursive calls
		System.out.println();
		System.out.println("---------------");

	}

	void DFSUtil(int s, boolean visited[]) {
		System.out.print(s + " ");
		visited[s] = true;
		for (Integer x : arr[s]) // pick neighbors of s one by one
		{
			if (!visited[x]) // If x is an unvisited neighbor
			{
				DFSUtil(x, visited); // Do DFS on that neighbor
			}
		}
	}

	void DFSOverall() {
		System.out.println("------DFS Overall------");
		boolean visited[] = new boolean[v];
		int count = 0;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				DFSUtil(i, visited); // Utility/Helper Function -> To pass the same array to all recursive calls
				System.out.println();
				count++;
			}
		}
		System.out.println("Total Connected Components: " + count);
		System.out.println("---------------");
	}
}

public class GraphLL {

	public static void main(String[] args) {
		Graph g = new Graph(8);
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

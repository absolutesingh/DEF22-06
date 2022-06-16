package graphs;

import java.util.Scanner;

public class GraphAlgos {
	
	static int[] dijkstra(int adjMatrix[][], int source)
	{
		int v = adjMatrix.length; //No. of vertices
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		
		for (int i = 0; i < v; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;
		
		for(int i=0;i<v-1;i++)
		{
			int minVertex = findMinVertex(distance, visited); //it will return the index of minVertex
			visited[minVertex] = true;
			//Traversing the neighbors row
			for (int j = 0; j < v; j++) {
				//Traversing the unvisited neighbors
				if(adjMatrix[minVertex][j]!=0 && !visited[j]) //Not zero means neighbor
				{
					int newDistance = distance[minVertex] + adjMatrix[minVertex][j];
					if(newDistance < distance[j])
					{
						distance[j] = newDistance;
					}
				}
			}
		}
		
		return distance;
	}
	
	static int findMinVertex(int distance[], boolean visited[])
	{
		int v = distance.length;
		int minVertex = -1; //Index
		//We can't assume the min to be at index 0 because the element at index 0
		//might already be visited and hence it won't be a part of our comparison
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				if(minVertex == -1) //we're visiting the first unvisited node
				{
					minVertex = i;
				}
				else if(distance[i]<distance[minVertex])
				{
					minVertex = i;
				}
			}
			
		}
		return minVertex;
	}
	
	static void print(int arr[], String msg) {
		System.out.println(msg);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of vertices: ");
		int v = sc.nextInt();
		System.out.println("Enter no. of edges: ");
		int e = sc.nextInt();
		int adjMatrix[][] = new int[v][v];
		System.out.println("Enter all edges with weight: ");
		for (int i = 0; i < e; i++) {
			int startVertex = sc.nextInt();
			int endVertex = sc.nextInt();
			int w = sc.nextInt();
			adjMatrix[startVertex][endVertex] = w;
			adjMatrix[endVertex][startVertex] = w; // bidirectional graph
		}
		sc.close();

		int shortestPathFromZero[] = dijkstra(adjMatrix, 0);
		print(shortestPathFromZero, "Dijkstras with 0 as source");
	}

}

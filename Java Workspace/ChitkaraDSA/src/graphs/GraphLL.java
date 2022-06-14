package graphs;

import java.util.LinkedList;

class Graph
{
	int v; //No. of vertices
//	int arr[] = new int[size];
//	String arr[] = new String[size];
	
	LinkedList<Integer> arr[];
	
	Graph(int v)
	{
		this.v = v;
		arr = new LinkedList[v]; //We've only created the array to store LinkedLists
		//as of now array has null at all the locations.
		
		for(int i=0;i<v;i++)
		{
			arr[i] = new LinkedList<>(); //Initializing empty LL's at each array position
		}
	}
	
	void addEdge(int u, int v) //(u,v) -> An edge from u to v.
	{
		arr[u].add(v); //in the neighbor list of u, add v
		//arr[v].add(u); -> If we want our graph to be bidirectional
	}
	
	void print()
	{
		for(int i=0;i<v;i++)
		{
			System.out.print("Neighbors of " + i + ": ");
			for(Integer x: arr[i]) //pick neighbors of i one by one from its neighbor list(arr[i])
			{
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
}

public class GraphLL {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.print();
	}

}

import java.util.*;

public class Dijkstra_testing001 {

	
	static ArrayList<Node>[] adjList;
	static int V;
	static int E;
	
	public static class Node{
		int vertex;
		int cost;
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		V = 4;
		E = 4;
		adjList = new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		adjList[0].add(new Node(3, 2));
		adjList[3].add(new Node(0, 2));
		
		adjList[0].add(new Node(1, 4));
		adjList[1].add(new Node(0, 4));
		
		adjList[1].add(new Node(2, 5));
		adjList[2].add(new Node(1, 5));
		
		adjList[3].add(new Node(2, 3));
		adjList[2].add(new Node(3, 3));
		
		
		
	}

}

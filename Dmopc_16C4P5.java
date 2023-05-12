import java.io.*;
import java.lang.*;
import java.util.*;

public class Dmopc_16C4P5 {

	static int V;
	static int E;
	static Edge[] edges;
	static ArrayList<Edge>[] adjList;
	static int[] maxCost;
	static boolean[] mstSet;
	static int[] parent;
	static int[] lowest_pref;
	static int[] lowest_pref2;
	static boolean[] visited;
	
	public static class Edge implements Comparable<Edge>{
		int ev;
		int cost;
		public Edge(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.cost - this.cost;
		}
	}
	
	public static int findMaximum() {
		int maxIndex = -1;
		int maxValue = Integer.MIN_VALUE;
		for (int i=0; i<maxCost.length; i++) {
			if (!mstSet[i] && maxCost[i] > maxValue) {
				maxValue = maxCost[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	// Traverse through all the points and store the minimum preference cost of that path
	// within "lowest_pref"
	public static void bfs() {  
		LinkedList<Integer> queue = new LinkedList<Integer>(); // Queue that stores the numbers of the vertices
		queue.add(0);
		visited[0] = true;
		lowest_pref[0] = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(int i=0; i<parent.length; i++) {
				
				if(parent[i] == num && !visited[i]) {
					//System.out.println(e.ev);
					if (lowest_pref[i] > maxCost[num]) {
						//System.out.println(num+ ": changed " + lowest_pref[e.ev] + " to " + maxCost[num]);
						lowest_pref[i] = maxCost[num];
					}
					queue.add(i);
					visited[i] = true; 
				}
			
				
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int V = Integer.parseInt(input1[0]);
		int E = Integer.parseInt(input1[1]);
		
		edges = new Edge[E];
		adjList = new ArrayList[V];
		
		for (int i=0; i<V; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for (int i=0; i<E; i++) {
			String[] input = br.readLine().split(" ");
			int bv = Integer.parseInt(input[0]);
			int ev = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			adjList[bv-1].add(new Edge(ev-1, cost));
			adjList[ev-1].add(new Edge(bv-1, cost));
		}
		
		parent = new int[V];
		maxCost = new int[V];
		mstSet = new boolean[V];
		lowest_pref2 = new int[V];
		
		Arrays.fill(parent, -1);
		Arrays.fill(maxCost, Integer.MIN_VALUE);
		
		parent[0] = 0;
		maxCost[0] = Integer.MAX_VALUE;
		lowest_pref2[0] = Integer.MAX_VALUE;
		// Execute Prim's Algorithm
		
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(0, Integer.MAX_VALUE));
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			if(maxCost[edge.ev] != edge.cost) continue;
			// weird if statement here checking if the cost of next key is the same as the cost in max
			int nextKey = edge.ev;
			mstSet[nextKey] = true;
			lowest_pref2[nextKey] = Math.min(maxCost[nextKey], lowest_pref2[parent[nextKey]]);
			
			for(Edge e: adjList[nextKey]) {
				if (!mstSet[e.ev] && maxCost[e.ev] < e.cost) {
					maxCost[e.ev] = e.cost;
					parent[e.ev]= nextKey; 
					queue.add(new Edge(e.ev, e.cost));
				}
			}
			
			
			
		}
//		while(true) {
//			int nextKey = findMaximum();
//			if (nextKey == -1) {
//				break;
//			}
//			
//			mstSet[nextKey] = true;
//			lowest_pref2[nextKey] = Math.min(maxCost[nextKey], lowest_pref2[parent[nextKey]]);
//
//			
//			for(Edge e: adjList[nextKey]) {
//				if (!mstSet[e.ev] && maxCost[e.ev] < e.cost) {
//					maxCost[e.ev] = e.cost; 
//					parent[e.ev] = nextKey; 
//				}
//			}
//		}
		
		//Output minimum spanning tree
//		System.out.println("-----MST-----");
//		for(int i=1; i<parent.length; i++) {
//			System.out.println(i+1 + " " + (parent[i]+1) + " " + maxCost[i]);
//		}
//		
//		// Perform bfs
//		lowest_pref = maxCost.clone();
//		visited = new boolean[V];
//		bfs();
//		lowest_pref[0] = 0;
//		System.out.println("-----solution-----");
//		for (int i: lowest_pref) System.out.println(i);
//		System.out.println("-----comparison(original)-----");
//		for (int i: maxCost) System.out.println(i);
		lowest_pref2[0] = 0;
		for(int i: lowest_pref2) System.out.println(i);
		
/*
TESTING

#1
6 7
1 2 5
1 4 7
1 3 18
2 4 10
3 6 7
3 5 4
4 6 2

#2

9 12
1 2 7
1 3 31
2 4 10
3 9 8
9 8 7
8 7 23
3 8 40
4 5 20
5 6 15
4 7 16
6 7 29
3 6 6
*/
		
		
		
		
		
		
	}

}

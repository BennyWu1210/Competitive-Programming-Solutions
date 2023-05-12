import java.io.*;
import java.util.*;
import java.lang.*;


public class Java3Test {

	public static class PrimNode{
		int bv;
		int cost;
		
		public PrimNode(int bv, int cost) {
			this.bv = bv;
			this.cost = cost;
		}
		
	}
	
	public static class KruskalNode implements Comparable<KruskalNode>{
		int bv;
		int ev;
		int cost;
		
		public KruskalNode(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(KruskalNode o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	public static int find(int v, int[] parent) {
		if(parent[v] == -1){
			return v;
		}
		return parent[v] = find(parent[v], parent);
	}
	
	public static int minKey(boolean[] mstSet, int[] key) {
		int minIndex = -1;
		int minCost = Integer.MAX_VALUE;
		
		for(int i=0; i<key.length; i++) {
			if (!mstSet[i] && key[i] < minCost) {
				minCost = key[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	public static ArrayList<PrimNode>[] AdjList;
	public static int[][] AdjMatrix;
	public static int Edges;
	public static int Nodes;
	public static KruskalNode[] edges;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//triwayedu101@gmail.com
		
		//Task 1:
		//Store right side graph into AdjList
		//output vertex 2's all the neighbor vertex
		System.out.println("---Task 1---");
		Nodes = 5;
		Edges = 6;
		AdjList = new ArrayList[Nodes];
		
		for(int i=0; i<Nodes; i++) {
			AdjList[i] = new ArrayList<PrimNode>();
		}
		
		AdjList[0].add(new PrimNode(2, 5));
		AdjList[2].add(new PrimNode(0, 5));
		
		AdjList[0].add(new PrimNode(1, 6));
		AdjList[1].add(new PrimNode(0, 6));
		
		AdjList[1].add(new PrimNode(2, 7));
		AdjList[2].add(new PrimNode(1, 7));
		
		AdjList[2].add(new PrimNode(3, 3));
		AdjList[3].add(new PrimNode(2, 3));
		
		AdjList[3].add(new PrimNode(4, 2));
		AdjList[4].add(new PrimNode(3, 2));
		
		AdjList[2].add(new PrimNode(4, 8));
		AdjList[4].add(new PrimNode(2, 8));
		
		for(PrimNode nodes: AdjList[2]) {
			System.out.println(nodes.bv);
		}
		
		
		//Task 2:
		//Store right side graph into Edge array and sort based on cost
		//output bv, ev and cost of all the edge that the cost is smaller than 5 
		System.out.println("---Task 2---");
		edges = new KruskalNode[Edges];
		edges[0] = new KruskalNode(0, 2, 5);
		edges[1] = new KruskalNode(0, 1, 6);
		edges[2] = new KruskalNode(1, 2, 7);
		edges[3] = new KruskalNode(2, 3, 3);
		edges[4] = new KruskalNode(2, 4, 8);
		edges[5] = new KruskalNode(3, 4, 2);
		Arrays.sort(edges);
		for(KruskalNode node: edges) {
			if(node.cost < 5) {
				System.out.println(node.bv + " " + node.ev + " " + node.cost);
			}
		}
		
		//Task 3
		//Store right side graph into 2D array
		//output vertex 2's all the neighbor vertex and the cost
		System.out.println("---Task 3---");
		AdjMatrix = new int[Nodes][Nodes];
		
		AdjMatrix[0][2] = 5;
		AdjMatrix[2][0] = 5;
		
		AdjMatrix[0][1] = 6;
		AdjMatrix[1][0] = 6;
		
		AdjMatrix[1][2] = 7;
		AdjMatrix[2][1] = 7;
		
		AdjMatrix[2][3] = 3;
		AdjMatrix[3][2] = 3;
		
		AdjMatrix[3][4] = 2;
		AdjMatrix[4][3] = 2;
		
		AdjMatrix[2][4] = 8;
		AdjMatrix[4][2] = 8;
		
		for(int i=0; i<AdjMatrix[2].length; i++) {
			if (AdjMatrix[2][i] != 0) {
				System.out.println(i + " " + AdjMatrix[2][i]);
			}
			
		}
		
		//Task 4:
		System.out.println("---Task 4---");
		int[] parent = {-1,0,1,2,3,4,5};
		//using find function which we learn from Kruskal to output the root of vertex 6
		System.out.println(find(6, parent));
		
		//Task 5:
		System.out.println("---Task 5---");
		boolean[] mstSet = {false, true, false, false, true};
		int[] lowcost = {5,7,8,4,3};
		//using minKey function we learn from Prim to find out 
		//the next lowest cost vertex to add into MST tree
		System.out.println(minKey(mstSet, lowcost));
		
	    //Task 6:
		// ...
		System.out.println("---Task 6---");
		int[] A = {1,2,3,4,5,6};
		int[] B = {5,6,7,3,9,2};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0; i<A.length; i++) {
			pq.offer(A[i] + B[A.length-i-1]);
		}
		
		System.out.println(pq.poll());
		
		
		
		

	}

}
import java.io.*;
import java.util.*;
public class CCC03S5_REDO {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class Node implements Comparable<Node>{
		int city;
		int cost;
		public Node(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	public static int[] parent;
	public static int[] maxCost;
	public static ArrayList<Node>[] adjList;
	public static boolean[] mstSet;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int c = readInt();
		int r = readInt();
		int d = readInt();
		
		adjList = new ArrayList[c];
		for(int i=0; i<c; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<r; i++) {
			int bv = readInt()-1;
			int ev = readInt()-1;
			int cost = readInt();
			adjList[bv].add(new Node(ev, cost));
			adjList[ev].add(new Node(bv, cost));
		}
		
		parent = new int[c];
		mstSet = new boolean[c];
		maxCost = new int[c];
		Arrays.fill(parent, -1);
		Arrays.fill(maxCost, Integer.MIN_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(Collections.reverseOrder());
		pq.add(new Node(0, Integer.MAX_VALUE));
		maxCost[0] = Integer.MAX_VALUE;
		parent[0] = 0;
		
		while(!pq.isEmpty()) {
			Node next = pq.poll();
			if (next.cost != maxCost[next.city]) {
				continue;
			}
			mstSet[next.city] = true;
			
			for(Node n: adjList[next.city]) {
				if (!mstSet[n.city] && n.cost > maxCost[n.city]) {
					maxCost[n.city] = n.cost;
					parent[n.city] = next.city;
					pq.add(new Node(n.city, n.cost));
					
				}
			}
			
		}
		
		// checks if mst worked or not
//		for(int i=0; i<parent.length; i++) {
//			System.out.println((i+1) + " " + (parent[i]+1) + " " + maxCost[i]);
//		}
		
		
		// Perform backtracking
		
		boolean[] visited = new boolean[c];
		int[] destination = new int[d];
		for(int i=0; i<d; i++) {
			destination[i] = readInt()-1;
		}
		
		int minValue = Integer.MAX_VALUE;
		visited[0] = true;
		for(int des: destination) {
			while(!visited[des]) {
				minValue = Math.min(minValue, maxCost[des]);
				visited[des] = true;
				des = parent[des];
			}
		}
		
		System.out.println(minValue);
		
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}

}

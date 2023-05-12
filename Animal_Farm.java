
import java.io.*;
import java.util.*;

public class Animal_Farm {

	// shortened version
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node{
		int u, cost;
		
		public Node(int u, int cost) {
			this.u = u;
			this.cost = cost;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int u, v, cost;
		
		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	
	static Map<String, int[]> map = new HashMap();
	static ArrayList<Node>[] adj = new ArrayList[101];
	static ArrayList<Edge> edges = new ArrayList();
	static int[] parent = new int[101];
	static int[] pens = new int[101];
	
	static int find(int u) {
		if (parent[u] == -1) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static void merge(int u, int v) {
		if (pens[u] > pens[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		pens[v] += pens[u];
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		for (int i=0; i<=100; i++) adj[i] = new ArrayList();
		
		List<String> strings = new ArrayList();
		Arrays.fill(parent, -1);
		
		
		for (int i=1; i<=N; i++) {
			pens[i] = 1;
			
			int m = readInt();
			
			int[] nodes = new int[m], costs = new int[m];
			
			for (int j=0; j<m; j++) nodes[j] = readInt();
			for (int j=0; j<m; j++) costs[j] = readInt();
			
			
			for (int j=0; j<m; j++) {
				int u = nodes[(j) % m], v = nodes[(j + 1) % m];
				int c = costs[j];
				
				if (u > v) {
					int temp = u;
					u = v;
					v = temp;
				}
	
				String str = u + " " + v;
				
				if (map.containsKey(str)) {
					// If already processed this edge, connect the pens
					int next = map.get(str)[0];
					adj[i].add(new Node(next, c));
					
					// set this to -1 to show that it is not an edge connected to the outside
					map.put(str, new int[] {-1, 0});
				}
				else {
					// otherwise, store it into the  map
					map.put(str, new int[] {i, c});
					strings.add(str);
				}
			}
			
		}
		
		// Node 0 is the outside edge
		for (String s: strings) {
			int[] next = map.get(s);
			if (next[0] != -1) {
				
				// connect with outside (the nodes that doesn't have -1)
				adj[0].add(new Node(next[0], next[1]));
			}
		}
		
		// Store edges (exclude 0)
		for (int i=1; i<=100; i++) {
			for (Node n: adj[i]) {
				edges.add(new Edge(i, n.u, n.cost));
			}
		}
		
		Collections.sort(edges);
		
		// Case 1 (does not include outside)
		int cost1 = 0, cost2 = 0;
		
		for (Edge e: edges) {
			int u = find(e.u), v = find(e.v);
			if (u != v) {
				merge(u, v);
				cost1 += e.cost;
				
				if (pens[u] == N || pens[v] == N) break;
			}
		}
		
		// Case 2 (include outside)
		
		// Add the connections with outside
		for (Node n: adj[0]) {
			edges.add(new Edge(0, n.u, n.cost));
		}
		
		// Reset everything
		Collections.sort(edges);
		Arrays.fill(parent, -1);
		
		for (int i=1; i<=N; i++) pens[i] = 1;
		
		for (Edge e: edges) {
			
			int u = find(e.u), v = find(e.v);
			if (u != v) {
				merge(u, v);
				cost2 += e.cost;
				
				if (pens[u] == N || pens[v] == N) break;
			}
		}
		
		System.out.println(Math.min(cost1, cost2));
		
		
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


	
	

import java.util.*;
import java.io.*;


public class nccc2s5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	  
	public static class Node {
		int ev, cost;

		public Node(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
	}

	public static class Edge implements Comparable<Edge> {
		public int u;
		public int v;
		public int cost;

		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.cost - this.cost;
		}
	}

	public static ArrayList<Edge> edges;
	public static ArrayList<Edge> sorted_edges;
	public static int V;
	public static int E;
	public static int[] parent;
	public static ArrayList<Node>[] adj;
	public static boolean[] vis;

	public static int bsearch(int l, int r, int cost) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (sorted_edges.get(mid).cost > cost)
				l = mid + 1;
			else if (sorted_edges.get(mid).cost < cost)
				r = mid - 1;
			else {
				return mid;
			}
		}
		return l;
	}

	public static void mst() {
		for (int i = 0; i < sorted_edges.size(); i++) {
			Edge cur = sorted_edges.get(i);
			if (find(cur.u) != find(cur.v)) {
				adj[cur.u].add(new Node(cur.v, cur.cost));
				adj[cur.v].add(new Node(cur.u, cur.cost));
				union(cur.u, cur.v);
			}
		}
	}

	public static int find(int v) {
		if (parent[v] == -1) return v;
		return parent[v] = find(parent[v]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[b] = a;
	}

	public static void update() {
		// reset the values and run MST
		parent = new int[V + 1];
		adj = new ArrayList[V + 1];
		for (int j = 1; j <= V; j++) {
			adj[j] = new ArrayList<Node>();
		}
		Arrays.fill(parent, -1);
		mst();
	}

	public static void dfs(int u, int b, int w) {
		vis[u] = true;
		if (u == b) return;
		
		for (Node next : adj[u]) {
			// if the new node is not visited, and the edge to that node is at least w
			if (!vis[next.ev] && next.cost >= w) {
				// continue to dfs
				dfs(next.ev, b, w);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// take input
		V = readInt(); E = readInt();

		edges = new ArrayList<Edge>();
		for (int i = 0; i < E; i++) {
			int bv = readInt(), ev = readInt(), cost = readInt();
			edges.add(new Edge(bv, ev, cost));
		}

		// create another arraylist that keeps track of the edges (sorted in decreasing order)
		sorted_edges = new ArrayList<Edge>(edges);
		
		// sort the edges
		Collections.sort(sorted_edges);
		
		// reset the values and build mst
		update();

		int Q = readInt();
		for (int i = 0; i < Q; i++) {
			int op = readInt();
			
			// update:
			if (op == 1) {
				int m = readInt(), x = readInt();
				
				Edge current = edges.get(m - 1); // take the current edge
			
				// serach for the position of the current edge in the ArrayList
				int ind = bsearch(0, E - 1, current.cost); 
				
				// remove that edge
				sorted_edges.remove(ind);
				
				// search for the position where the new edge belongs
				int new_ind = bsearch(0, E - 2, x);
				
				// add the new edge (with an updated cost)
				sorted_edges.add(new_ind, new Edge(current.u, current.v, x));
				
				// finally, update the cost of the current edge
				current.cost = x;
				
				// build mst
				update(); 
			} 
			
			// query:
			else {
				int a = readInt(), b = readInt(), w = readInt();
				vis = new boolean[V + 1];
				// use DFS to check if you can go from a to b with cost >= w
				dfs(a, b, w);
				
				// if node b is visited, that means it can be reached
				System.out.println(vis[b] ? 1 : 0);
			}

		}

	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
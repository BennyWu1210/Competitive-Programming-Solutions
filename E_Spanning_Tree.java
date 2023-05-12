
import java.io.*;
import java.util.*;

public class E_Spanning_Tree {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] root;
	static int[] rank;
	static Edge[] edges;
	
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
	
	static int find(int u) {
		if (root[u] == u) return u;
		return root[u] = find(root[u]);
	}
	
	static void union(int u, int v) {
		
		u = find(u); v = find(v);
		
		if (u != v) {
			if (rank[u] == rank[v]) {
				rank[u] ++;
			}
			
			if (rank[u] > rank[v]) {
				root[v] = u;
			}
			else {
				root[u] = v;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		
		edges = new Edge[m];
		root = new int[n];
		rank = new int[n];
		
		for (int i=0; i<n; i++) {
			root[i] = i;
		}
		
		for (int i=0; i<m; i++) {
			int u = readInt()-1, v = readInt()-1, w = readInt();
			
			edges[i] = new Edge(u, v, w);
		}
		
		Arrays.sort(edges);
		
		long cost = 0;
		int totalEdges = 0;
		for (Edge e: edges) {
			int uroot = find(e.u), vroot = find(e.v);
			if (uroot != vroot) {
				union(uroot, vroot);
				cost += e.cost;
				totalEdges ++;
				
				if (totalEdges == n-1) {
					break;
				}
			}
		}
		
		System.out.println(cost);
		
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


	
	

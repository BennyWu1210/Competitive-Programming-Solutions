
import java.io.*;
import java.util.*;

public class ccc03s5_disjoint_set {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node{
		int min, dest, par, count;
		
		public Node(int min, int dest, int par) {
			this.min = min;
			this.dest = dest;
			this.par = par;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int u, v, w;
		
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.w - this.w;
		}
	}
	
	static int c, r, d;
	static int MM = (int)1e5 + 5;
	static Edge[] edges;
	static Node[] nodes = new Node[10005];
	
	static int find(int u) {
		if (nodes[u].par == u) return u;
		return nodes[u].par = find(nodes[u].par);
	}
	
	static void merge(int a, int b, int c) {
		a = find(a);
		b = find(b);
		
		if (a == b) return;
		
		Node u = nodes[a];
		Node v = nodes[b];
		
		if (u.count < v.count) {
			u.par = v.par;
			v.dest += u.dest;
			v.count += u.count;
			v.min = Math.min(c, Math.min(u.min, v.min));
		}
		else {
			v.par = u.par;
			u.dest += v.dest;
			u.count += v.count;
			u.min = Math.min(c, Math.min(u.min, v.min));
		}
		
		
		if (u.dest == d) {
			System.out.println(u.min);
			System.exit(0);
		}
		else if (v.dest == d) {
			System.out.println(v.min);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws IOException {

		c = readInt(); r = readInt(); d = readInt();
		edges = new Edge[r];
		
		for (int i=0; i<r; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			edges[i] = new Edge(u, v, w);
		}
		
		for (int i=1; i<nodes.length; i++) {
			nodes[i] = new Node(Integer.MAX_VALUE, 0, i);
			nodes[i].count = 1;
		}
		
		for (int i=0; i<d; i++) {
			int u = readInt();
			nodes[u].dest = 1;
		}
		

		Arrays.sort(edges);
		
		for (Edge e: edges) {
			merge(e.u, e.v, e.w);
			
		}
		
		
		
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


	
	

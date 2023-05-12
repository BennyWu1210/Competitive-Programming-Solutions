
import java.io.*;
import java.util.*;

public class D_CuttingAGraph {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Edge{
		int u, v;
		
		public Edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
	
	static int find(int u) {
		return (u == parent[u]) ? u : (parent[u] = find(parent[u])); 
	}
	
	static Edge[] edges;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {

		
		int n = readInt(), m = readInt(), k = readInt();
		
		for (int i=0; i<m; i++) {
			// seems like the edges do not matter?
			
			readLine();
		}
		
		boolean[] actions = new boolean[k];
		edges = new Edge[k];
		
		for (int i=0; i<k; i++) {
			String[] input = readLine().split(" ");
			int u = Integer.parseInt(input[1]);
			int v = Integer.parseInt(input[2]);
			actions[i] = (input[0].equals("cut"));
			edges[i] = new Edge(u, v);
		}
		
		parent = new int[n+1];
		
		Stack<Boolean> res = new Stack<>();
		
		
		for (int i=1; i<=n; i++) parent[i] = i;
		
		for (int i = k-1; i>=0; i--) {
			int u = edges[i].u, v = edges[i].v;
			
			u = find(u);
			v = find(v);
			
			if (actions[i]) parent[u] = v;
			else res.push((u == v));
		}
		
		while (!res.isEmpty()) System.out.println(res.pop() ? "YES" : "NO");
		
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


	
	


import java.io.*;
import java.util.*;


public class CCO15P2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node{
		int v, mask;
		
		public Node(int v, int mask) {
			this.v = v;
			this.mask = mask;
		}
	}
	
	static class Edge{
		int v, w;
		
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

	}
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		int[][] dp = new int[n][1<<n];
		ArrayList<Edge>[] adjList = new ArrayList[n];
		LinkedList<Node> queue = new LinkedList<Node>();
		
		for(int i=0; i<n; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<m; i++) {
			adjList[readInt()].add(new Edge(readInt(), readInt()));
		}
		
		queue.add(new Node(0, 1));
		dp[0][1] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(Edge e: adjList[cur.v]) {
				if ((cur.mask & (1 << e.v)) == 0) {
					int newMask = cur.mask | (1 << e.v);
					if (dp[e.v][newMask] < dp[cur.v][cur.mask] + e.w) {
						dp[e.v][newMask] = dp[cur.v][cur.mask] + e.w;
						
						queue.add(new Node(e.v, newMask));
					}
				}
			}
		}
		
		long ans = 0;
		for(int i=1; i<(1<<n); i++) {
			ans = Math.max(ans, dp[n-1][i]);
		}
		
		System.out.println(ans);
		
		
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


	
	


import java.io.*;
import java.util.*;

public class Lvl4_2021_p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = 1005;
	static int[][] dist = new int[MM][MM];
	static boolean[][] mat = new boolean[MM][MM];
	static List<Node>[] adj = new ArrayList[MM];
	
	static class Node{
		int u, c;
		public Node(int u, int c) {
			this.u = u; this.c = c;
		}
	}
	static void dfs(int u, int prev, int[] dist) {
		for (Node nxt: adj[u]) {
			if (nxt.u == prev) continue;
			dist[nxt.u] = Math.max(dist[u], nxt.c);
			dfs(nxt.u, u, dist);
		}
	}
	public static void main(String[] args) throws IOException {

		int N = readInt();
		for (int i=0; i<MM; i++) adj[i] = new ArrayList();
		
		long ans = 0;
		for (int i=1; i<=N-1; i++) {
			int u = readInt(), v = readInt(), c = readInt();
			adj[u].add(new Node(v, c));
			adj[v].add(new Node(u, c));
			mat[u][v] = true;
			mat[v][u] = true;
			ans += c;
		}

		for (int i=1; i<=N; i++) {
			int[] dist = new int[N+1];
			dfs(i, -1, dist);
			for (int j=i+1; j<=N; j++) {
				if (!mat[i][j]) {
					ans += dist[j] + 1;
				}
			}
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


	
	

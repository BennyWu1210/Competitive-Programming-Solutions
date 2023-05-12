
import java.io.*;
import java.util.*;

public class coci21c6p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int n, m;
	static List<Integer>[] adj;
	static int[] vis, in;
	static Queue<Integer> q;
	static List<Integer> sol;
	
	static void dfs(int u) {
		vis[u] = 1;
		for (int v: adj[u]) {
			if (vis[v] == 1) {
				System.out.println(-1);
				System.exit(0);
			}
			if (vis[v] != 2) {
				dfs(v);
			}
		}
		vis[u] = 2;
	}
	
	public static void main(String[] args) throws IOException {

		n = readInt(); m = readInt();
		adj = new ArrayList[n + 1];
		vis = new int[n + 1]; in = new int[n + 1];
		for (int i = 1; i <= n; i++) adj[i] = new ArrayList();
		
		for (int i = 1; i <= m; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v);
			in[v] ++;
		}
	
		q = new LinkedList();
		sol = new ArrayList();
		
		for (int i = 1; i <= n; i++) {
			if (vis[i] == 0) dfs(i);
			if (in[i] == 0) q.add(i);
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			sol.add(cur);
			for (int nxt: adj[cur]) {
				in[nxt] --;
				if (in[nxt] == 0) q.add(nxt);
			}
			
		}
		
		System.out.println(sol.size());
		for (int i = 0; i < sol.size(); i++) {
			System.out.println(sol.get(i) + " 0");
			
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


	
	

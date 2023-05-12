
import java.io.*;
import java.util.*;

public class subway {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = 4*(int)1e5 + 5;
	static int N; static long dia, ans;
	static List<Integer>[] adj = new ArrayList[MN];
	static long[] dp = new long[MN], ways = new long[MN];
	
	static void dfs(int u, int par) {
		ways[u] = 1;
		
		for (int v: adj[u]) {
			if (v == par) continue;
			dfs(v, u);
			
			if (dia < dp[u] + dp[v] + 1) {
				dia = dp[u] + dp[v] + 1;
				ans = ways[u] * ways[v];
			} else if (dia == dp[u] + dp[v] + 1) {
				ans += ways[u] * ways[v];
			}
			
			if (dp[u] < dp[v] + 1) {
				dp[u] = dp[v] + 1;
				ways[u] = ways[v];
			} else if (dp[u] == dp[v] + 1) {
				ways[u] += ways[v];
			}
		}
	}
	public static void main(String[] args) throws IOException {

		N = readInt();
		for (int i=1; i<=N; i++) adj[i] = new ArrayList();
		for (int i=1; i<N; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(1, -1);
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


	
	


import java.io.*;
import java.util.*;

public class dpp {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 + 5, MOD = (int)1e9 + 7;;
	static int N;
	static List<Integer>[] adj = new ArrayList[MN];
	static long[][] dp = new long[MN][2]; // dp[i][0] -> white, dp[i][1] -> black
	
	static void dfs(int u, int par) {
		dp[u][0] = dp[u][1] = 1;
		for (int v: adj[u]) {
			if (v == par) continue;
			dfs(v, u);
			dp[u][0] = dp[u][0] * (dp[v][0] + dp[v][1]) % MOD;
			dp[u][1] = dp[u][1] * (dp[v][0]) % MOD;
		}
		
	}
	public static void main(String[] args) throws IOException {

		N = readInt();
		
		for (int i=1; i<=N; i++) adj[i] = new ArrayList();
		for (int i=1; i<=N-1; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v); adj[v].add(u);
		}
		
		dfs(1, -1);
		System.out.println((dp[1][0] + dp[1][1]) % MOD);
		
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


	
	

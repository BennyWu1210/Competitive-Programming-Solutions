
import java.io.*;
import java.util.*;

public class DP_Independent_Set {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static long[][] dp;
	static ArrayList<Integer>[] adj;
	static int MOD = (int)1e9 + 7;
	static boolean[] vis;

	static void DFS (int u, int prev) {
		vis[u] = true;
		if (adj[u].size() == 1 && adj[u].get(0) == prev || adj[u].size() == 0) {
			return;
		}

		long zero = 0;
		long one = 0;
		for (int v: adj[u]) {

			if (!vis[v]) {
				DFS(v, u);

				zero = dp[v][0] + dp[v][1];
				one = dp[v][0];


				dp[u][0] = (dp[u][0] * zero) % MOD;
				dp[u][1] = (dp[u][1] * one) % MOD;


			}


		}
	}

	public static void main(String[] args) throws IOException {

		int n = readInt();

		adj = new ArrayList[n+1];
		dp = new long[n+1][2];

		for (int i=1; i<=n; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i=0; i<dp.length; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
		}

		for (int i=1; i<n; i++) {
			int u = readInt(), v = readInt();

			adj[u].add(v);
			adj[v].add(u);

		}

		vis = new boolean[n+1];
		DFS(1, -1);
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





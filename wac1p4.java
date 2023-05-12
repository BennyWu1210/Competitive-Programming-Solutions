
import java.io.*;
import java.util.*;

public class wac1p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MN = 1003, MOD = 998244353;
	static char[] color = new char[MN];
	static long[][][][] dp = new long[MN][MN][3][3];
	static int N, K;
	static List<Integer>[] adj = new ArrayList[MN];
	static long ans;
	static int[] size = new int[MN];

	static void dfs(int u, int par) {

		size[u] = 1;
		if (color[u] == 'R') dp[u][1][1][0] = 1;
		else dp[u][1][0][1] = 1;

		System.out.println(color[u]);
		for (int v: adj[u]) {
			if (v == par) continue;
			dfs(v, u);
			size[u] += size[v];

			long[][][] merged = new long[MN][3][3];
			for (int i=0; i<=Math.min(K, size[u]); i++) {
				for (int r1=0; r1<=2; r1++) {
					for (int b1=0; b1<=2; b1++) {
						for (int j=0; j<=Math.min(K-i, size[v]); j++) {
							for (int r2=0; r2<=2; r2++) {
								for (int b2=0; b2<=
										2; b2++) {
									long cur = dp[u][i][r1][b1];
									long nxt = dp[v][j][r2][b2];
									if (cur != 0) System.out.println(cur + " " + nxt);
									merged[i+j][Math.min(2, r1+r2)][Math.min(2, b1+b2)] += cur * nxt % MOD;
								}
							}
						}
					}
				}
			}

			for (int j=0; j<=K; j++) {
				for (int r=0; r<=2; r++) {
					for (int b=0; b<=2; b++) {
						dp[u][j][r][b] += merged[j][r][b];
					}
				}
			}




		}


	}
	public static void main(String[] args) throws IOException {

		N = readInt(); K = readInt();

		for (int i=1; i<=N; i++) adj[i] = new ArrayList();

		char[] s = readLine().toCharArray();
		for (int i=1; i<=N; i++) color[i] = s[i-1];

		for (int i=1; i<=N-1; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v); adj[v].add(u);
		}

		dfs(1, -1);
		for (int i=1; i<=N; i++) {
			ans = (ans + dp[i][K][2][2]) % MOD;
			System.out.println(dp[i][K][2][2]);
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





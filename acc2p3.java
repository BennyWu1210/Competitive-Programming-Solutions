
import java.io.*;
import java.util.*;

public class acc2p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MM = (int)1e5 + 5, LOG = 17;
	static List<int[]>[] adj = new ArrayList[MM];
	static int[][] up = new int[MM][LOG + 1], cost[] = new int[MM][LOG + 1][2];
	static int[] in = new int[MM], out = new int[MM], dep = new int[MM];
	static int timer;


	static void dfs(int u, int prev) {

		up[u][0] = prev;
		in[u] = ++timer;
		dep[u] = dep[prev] + 1;

		for (int i=1; i<=LOG; i++) {
			up[u][i] = up[up[u][i-1]][i-1];

			if (cost[up[u][i-1]][i-1][0] > cost[u][i-1][0]) {
				cost[u][i][0] = cost[up[u][i-1]][i-1][0];
				cost[u][i][1] = Math.max(cost[up[u][i-1]][i-1][1], cost[u][i-1][0]);
			} else {
				cost[u][i][0] = cost[u][i-1][0];
				cost[u][i][1] = Math.max(cost[up[u][i-1]][i-1][0], cost[u][i-1][1]);
			}
		}

		for (int[] nxt: adj[u]) {
			if (nxt[0] != prev) {
				cost[nxt[0]][0][0] = nxt[1];
				dfs(nxt[0], u);
			}
		}
		out[u] = ++timer;

	}

	static boolean isAncestor(int u, int v) {
		return in[u] <= in[v] && out[u] >= out[v]; 
	}

	static int query(int u, int v) {
		if (dep[u] > dep[v]) {
			int t = v;
			v = u;
			u = t;
		}

		if (isAncestor(u, v) && dep[v] - dep[u] < 2) return -1;
		int f = 0, s = 0;

		if (!isAncestor(u, v)) {
			for (int i=LOG; i>=0; i--) {
				if (up[u][i] != 0 && !isAncestor(up[u][i], v)) {
					if (cost[u][i][0] >= f) {
						s = Math.max(f, cost[u][i][1]);
						f = cost[u][i][0];

					} else if (cost[u][i][0] > s) {
						s = cost[u][i][0];
					}
					u = up[u][i];
				}
				
				if (isAncestor(up[u][0], v)) break;
			}
			if (cost[u][0][0] >= f){
				s = f;
				f = cost[u][0][0];
			} else if (cost[u][0][0] > s){
				s = cost[u][0][0];
			}
			u = up[u][0]; // u is now the LCA
		}

		for (int i=LOG; i>=0; i--) {
			if (in[u] <= in[up[v][i]]) {
				if (cost[v][i][0] <= f) {
					s = Math.max(s, cost[v][i][0]);
				}
				if (cost[v][i][0] >= f) {
					s = Math.max(f, cost[v][i][1]);
					f = cost[v][i][0];
				}
				if (cost[v][i][1] >= f) {
					s = f;
					f = cost[v][i][1];
				}

				v = up[v][i]; 
			}
			
			if (u == v) break;
		}

		return s;
	}

	public static void main(String[] args) throws IOException {

		int N = readInt();

		for (int i=0; i<=N; i++) adj[i] = new ArrayList();

		for (int i=0; i<N-1; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new int[]{v, w}); adj[v].add(new int[]{u, w});
		}


		dfs(1, 0);

		int Q = readInt();
		for (int i=0; i<Q; i++) {
			int u = readInt(), v = readInt();
			int ans = query(u, v);
			System.out.println(ans);
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





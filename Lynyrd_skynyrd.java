
import java.io.*;
import java.util.*;

public class Lynyrd_skynyrd {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = 2 * (int)1e5 + 3, LOG = 20;
	static List<Integer>[] pos, rNxt;
	static int[] adj, nxt, arr, p;
	static int n, m, q, timer;
	static int[][] anc;
	
	static void dfs(int u, int p) {
		anc[u][0] = p;
		for (int i = 1; i < LOG; i++) {
			anc[u][i] = anc[anc[u][i-1]][i-1];
		}
		
		for (int v: rNxt[u]) {
			dfs(v, u);
		}
	}
	
	static int calc(int ind) {
		int val = n - 1;
		int res = ind;
		for (int i = LOG - 1; i >= 0; i--) {
			if (val - (1 << i) >= 0) {
				val -= (1 << i);
				res = anc[res][i];
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		n = readInt(); m = readInt(); q = readInt();
		p = new int[n + 1]; nxt = new int[m + 2]; adj = new int[n + 1]; arr = new int[m + 2]; anc = new int[m + 2][LOG];
		pos = new ArrayList[n + 1]; rNxt = new ArrayList[m + 2];
		
		for (int i = 1; i <= n; i++) p[i] = readInt();
		for (int i = 1; i <= n; i++) {
			pos[i] = new ArrayList();
			int nxtNum = i + 1;
			if (nxtNum > n) nxtNum = 1;
			adj[p[i]] = p[nxtNum];
		}
		for (int i = 1; i <= m; i++) {
			arr[i] = readInt();
			pos[arr[i]].add(i);
		}
		
		
		for (int i = 1; i <= m + 1; i++) rNxt[i] = new ArrayList();

		for (int i = 1; i <= m; i++) {
			// nxt[arr[i]] = ?
			int flag = adj[arr[i]];
			int lft = 0, rit = pos[flag].size() - 1, ans = m + 1;
			while (lft <= rit) {
				int mid = (lft + rit) / 2;
				if (pos[flag].get(mid) > i) {
					ans = pos[flag].get(mid);
					rit = mid - 1;
				} else {
					lft = mid + 1;
				}
			}
			nxt[i] = ans;
			rNxt[ans].add(i);
		}
		
		dfs(m + 1, m + 1);
		
		for (int i = 1; i <= q; i++) {
			int lft = readInt(), rit = readInt();
			
			// System.out.println(calc(lft));
			if (calc(lft) <= rit) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
			
		}
		System.out.println();
		
		
		
		
		
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


	
	


import java.io.*;
import java.util.*;

public class treep3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5 * 2 + 5, LOG = 17;
	static int N, Q, T;
	static long[] seg = new long[8*MM], val = new long[MM];
	static int[] in = new int[MM], out = new int[MM], a = new int[2*MM], lca[] = new int[MM][LOG+1];
	static List<Integer>[] adj = new ArrayList[MM];
	
	static void dfs(int u, int par) {
		in[u] = ++T;
		
		lca[u][0] = par;
		for (int i=1; i<=LOG; i++) lca[u][i] = lca[lca[u][i-1]][i-1];
		
		for (int v: adj[u]) {
			if (v != par) dfs(v, u);
		}
		
		out[u] = ++T;
	}
	
	static void build(int l, int r, int x) {
		if (l == r) seg[x] = a[l];
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static void update(int l, int r, int x, int ind, int v) {
		if (l == r) seg[x] += v;
		else {
			int mid = (l + r) / 2;
			if (ind <= mid) update(l, mid, 2*x, ind, v);
			else update(mid+1, r, 2*x+1, ind, v);
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static long query(int l, int r, int x, int lef, int rit) {
		if (l > rit || r < lef) return 0;
		if (l >= lef && r <= rit) return seg[x];
		int mid = (l + r) / 2;
		return query(l, mid, 2*x, lef, rit) + query(mid+1, r, 2*x+1, lef, rit);
	}
	
	static boolean isAnc(int u, int v) {
		return in[u] <= in[v] && out[u] >= out[v];
	}
	
	static int findAnc(int u, int v) {
		if (isAnc(u, v)) return u;
		if (isAnc(v, u)) return v;
		
		for (int i=LOG; i>=0; i--) {
			if (lca[u][i] != 0 && !isAnc(lca[u][i], v)) u = lca[u][i];
		}
		
		return lca[u][0];
	}
	public static void main(String[] args) throws IOException {

		N = readInt(); Q = readInt();
		
		for (int i=1; i<MM; i++) adj[i] = new ArrayList();
		
		for (int i=1; i<=N; i++) val[i] = readInt();

		for (int i=1; i<N; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(1, 0);
		for (int i=1; i<=N; i++) {
			a[in[i]] += val[i];
			a[out[i] + 1] += -val[i];
		}
		
		
		build(1, 2*N, 1);

		
		for (int i=0; i<Q; i++) {
			int c = readInt(), a = readInt(), b = readInt();
			if (c == 1) {
				update(1, 2*N, 1, in[a], b);
				update(1, 2*N, 1, out[a] + 1, -b);
				val[a] += b;
			} else {
				int anc = findAnc(a, b);
				long ans = query(1, 2*N, 1, 1, in[a]) + query(1, 2*N, 1, 1, in[b]) - 2 * query(1, 2*N, 1, 1, in[anc]) + val[anc];
				System.out.println(ans);
			}
		}
		
/*
6
10
2 1 5 3 7 2
1 2
2 4
2 5
5 6
1 3
 */
		
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


	
	

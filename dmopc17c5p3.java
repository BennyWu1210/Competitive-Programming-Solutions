
import java.io.*;
import java.util.*;

public class dmopc17c5p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MM = (int)1e5 + 5, LOG = 17;
	static int N, Q;
	static int[] lft = new int[MM], rit = new int[MM], val = new int[MM], dep = new int[MM], best = new int[MM], anc[] = new int [LOG][MM];
	static List<endpoint> points = new ArrayList();
	static List<Integer> adj[] = new ArrayList[MM];

	static class endpoint implements Comparable<endpoint>{
		int x, id; // x is position, id is segment
		boolean end; // true if left, false if right

		public endpoint(int x, int id, boolean end) {
			this.x = x;
			this.id = id;
			this.end = end;
		}

		@Override
		public int compareTo(endpoint o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.x, o.x);
		}
	}

	static int LCA(int u, int v) {
		if (dep[u] < dep[v]) {
			int temp = u;
			u = v;
			v = temp;
		}

		for (int k=LOG-1; k>=0; k--) {
			if (anc[k][u] != -1 && dep[anc[k][u]] >= dep[v]) u = anc[k][u];
		}

		if (u == v) return anc[0][v];

		for (int k=LOG-1; k>=0; k--) {
			if (anc[k][u] != -1 && anc[k][v] != -1 && anc[k][u] != anc[k][v]) {
				u = anc[k][u];
				v = anc[k][v];
			}
		}

		return anc[0][u];
	}
	static void dfs(int u, int p) {
		anc[0][u] = p;
		if (u > 0) {
			best[u] = (val[u] <= val[best[p]]) ? u : best[p];
		}

		for (int k=1; k<LOG; k++) {
			int ind = anc[k-1][u];
			if (ind == -1) break;
			anc[k][u] = anc[k-1][ind];
		}


		for (int v: adj[u]) {
			if (v != p) {
				dep[v] = dep[u] + 1;
				dfs(v, u);
			}
		}
	}
	public static void main(String[] args) throws IOException {

		N = readInt();

		for (int i=0; i<LOG; i++) Arrays.fill(anc[i], -1);
		for (int i=0; i<MM; i++) adj[i] = new ArrayList();

		for (int i=1; i<=N; i++) {
			lft[i] = readInt(); rit[i] = readInt(); val[i] = readInt();
			points.add(new endpoint(lft[i], i, true));
			points.add(new endpoint(rit[i], i, false));
		}

		Collections.sort(points);
		Stack<Integer> stk = new Stack();
		stk.push(0);

		for (endpoint e: points) {
			if (e.end) { // left
				adj[stk.peek()].add(e.id);
				stk.push(e.id);
			}else {
				stk.pop();
			}
		}

		val[0] = (int)1e9; dfs(0, -1);

		Q = readInt();
		for (int i=1; i<=Q; i++) {
			int u = readInt(), v = readInt();
			int rt = LCA(u, v);
			System.out.println((rt == 0 ? -1 : best[rt]));
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





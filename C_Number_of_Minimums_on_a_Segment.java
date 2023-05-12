
import java.io.*;
import java.util.*;

public class C_Number_of_Minimums_on_a_Segment {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int MM = (int)1e5 + 5, INF = (int)1e9 + 5;
	static int[] arr = new int[MM];
	static int[][] seg = new int[4*MM][2];

	static class pair{
		int v, c;

		public pair(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static int[] merge(int[] a, int[] b) {
		if (a[0] < b[0]) return a;
		if (a[0] > b[0]) return b;

		return new int[] {a[0], a[1] + b[1]};
	}

	static void build(int x, int lx, int rx) {
		if (lx == rx) seg[x] = new int[]{arr[lx], 1};
		else {
			int m = (lx + rx) / 2;
			build(2*x, lx, m);
			build(2*x+1, m+1, rx);

			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}

	static void update(int x, int lx, int rx, int i, int v) {
		if (lx == rx) seg[x] = new int[]{v, 1};
		else {
			int m = (lx + rx) / 2;

			if (i <= m) update(2*x, lx, m, i, v);
			else update(2*x+1, m+1, rx, i, v);

			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}

	static int[] query(int x, int lx, int rx, int l, int r) {
		if (lx > r || rx < l) return new int[]{INF, 0};
		if (lx >= l && rx <= r) return seg[x];

		int m = (lx + rx) / 2;
		return merge(query(2*x, lx, m, l, r), query(2*x+1, m+1, rx, l, r));
	}

	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();

		for (int i=1; i<=n; i++) arr[i] = readInt();

		build(1, 1, n);
		
		for (int i=0; i<m; i++) {
			int a = readInt(), b = readInt()+1, c = readInt();

			if (a == 1) {
				update(1, 1, n, b, c);
			}
			else {
				int[] res = query(1, 1, n, b, c);
				System.out.printf("%d %d\n", res[0], res[1]);
			}
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





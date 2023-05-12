
import java.io.*;
import java.util.*;

public class B_Kth_one {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MM = (int)1e5 + 5;
	static int[] arr = new int[MM], seg = new int[4*MM];
	static int n, m;

	static void build(int l, int r, int x) {
		if (l == r) seg[x] = arr[l];
		else {
			int mid = (l + r) / 2;

			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);

			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}

	static void update(int l, int r, int x, int ind) {
		if (l == r) seg[x] ^= 1;
		else {
			int mid = (l + r) / 2;
			
			if (ind <= mid) update(l, mid, 2*x, ind);
			else update(mid+1, r, 2*x+1, ind);
			
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static int query(int l, int r, int x, int k) {
		if (l == r) {
			return l;
		}
		
		int mid = (l + r) / 2;
		if (seg[2*x] <= k) {
			return query(mid+1, r, 2*x+1, k-seg[2*x]);
		}
		else {
			return query(l, mid, 2*x, k);
		}
		
	}
	public static void main(String[] args) throws IOException {

		n = readInt(); m = readInt();

		for (int i=1; i<=n; i++) {
			arr[i] = readInt();
		}

		build(1, n, 1);
		for (int i=0; i<m; i++) {
			int c = readInt();

			int u = readInt();
			if (c == 1) {
				update(1, n, 1, u + 1);
			}
			else if (c == 2) {
				System.out.println(query(1, n, 1, u) - 1);
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






import java.io.*;
import java.util.*;

public class dmopc15c1p6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5 * 2 + 10, MIN = Integer.MIN_VALUE;
	static long[] arr = new long[MM], seg = new long[4*MM], lzy = new long[4*MM];
	static int n, q;
	static long m;
	static void build(int l, int r, int x) {
		if (l == r) seg[x] = arr[l];
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static void update(int l, int r, int x, int lef, int rig, long v) {
		push_down(l, r, x);
		if (l > rig || r < l || r < lef) return;
		if (l >= lef && r <= rig) {
			seg[x] += (r-l+1)*v;
			
			if (l != r) {
				lzy[2*x] += v;
				lzy[2*x+1] += v;
			}
		}
		else {
			int mid = (l + r) / 2;
			update(l, mid, 2*x, lef, rig, v);
			update(mid+1, r, 2*x+1, lef, rig, v);
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static long query(int l, int r, int x, int a, int b) {
		if (l > b || r < l || r < a) return 0;
		push_down(l, r, x);
		if (l >= a && r <= b) return seg[x];
		
		int mid = (l + r) / 2;
		long left = query(l, mid, 2*x, a, b);
		long right = query(mid+1, r, 2*x+1, a, b);
		
		return left + right;
	}
	
	static void push_down(int l, int r, int x) {
		if (lzy[x] == 0) return;
		seg[x] += (r-l+1)*lzy[x]; // two children
		
		if (l != r) {
			lzy[2*x] += lzy[x];
			lzy[2*x+1] += lzy[x];
		}
		
		lzy[x] = 0;
	}
	
	public static void main(String[] args) throws IOException {

		m = readLong(); n = readInt(); q = readInt();
		
		for (int i=1; i<=n; i++) {
			arr[i] = readLong();
		}
		
		Arrays.fill(lzy, MIN);
		build(1, n, 1);
		
		for (int i=0; i<q; i++) {
			int c = readInt();
			
			if (c == 1) {
				int l = readInt(), r = readInt(); long v = readLong();
				update(1, n, 1, l, r, v);
			}
			else {
				int l = readInt(), r = readInt();
				long ans = query(1, n, 1, l, r);
				System.out.println(ans % m);
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


	
	

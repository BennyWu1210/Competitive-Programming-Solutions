
import java.io.*;
import java.util.*;

public class B_Segment_Tree_for_the_Minimum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = (int)1e5 + 5, INF = (int)1e9 + 5;
	static int[] arr = new int[MM], seg = new int[4*MM];
	
	static void build(int x, int lx, int rx) {
		if (lx == rx) seg[x] = arr[lx];
		else {
			int m = (lx + rx) / 2;
			build(2*x, lx, m);
			build(2*x+1, m+1, rx);
			
			seg[x] = Math.min(seg[2*x], seg[2*x+1]);
		}
		
	}
	
	static void update(int i, int v, int x, int lx, int rx) {
		if (lx == rx) seg[x] = v;
		else {
			int m = (lx + rx) / 2;
			if (i <= m) update(i, v, 2*x, lx, m);
			else update(i, v, 2*x+1, m+1, rx);
			seg[x] = Math.min(seg[2*x], seg[2*x+1]);
		}
	}
	
	static int getMin(int l, int r, int x, int lx, int rx) {
		if (lx > r || rx < l) return INF;
		if (lx >= l && rx <= r) return seg[x];
		int m = (lx + rx) / 2;
		return Math.min(getMin(l, r, 2*x, lx, m), getMin(l, r, 2*x+1, m+1, rx));
	}
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		Arrays.fill(arr, INF);
		Arrays.fill(seg, INF);
		
		for (int i=1; i<=n; i++) arr[i] = readInt();
		
		build(1, 1, n);
		for (int i=0; i<m; i++) {
			int a = readInt(), b = readInt() + 1, c = readInt();
			
			if (a == 1) {
				update(b, c, 1, 1, n);
			}
			else {
				System.out.println(getMin(b, c, 1, 1, n));
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


	
	

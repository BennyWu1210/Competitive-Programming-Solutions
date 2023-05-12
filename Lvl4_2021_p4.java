
import java.io.*;
import java.util.*;

public class Lvl4_2021_p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = 2*(int)1e5 + 5;
	static int[] seg = new int[4*MM];

	static void update(int l, int r, int x, int ind, int v) {
		if (l == r) seg[x] = v;
		else {
			int mid = (l + r) / 2;
			if (ind <= mid) update(l, mid, 2*x, ind, v);
			else update(mid+1, r, 2*x+1, ind, v);
			seg[x] = Math.max(seg[2*x], seg[2*x+1]);
		}
	}
	
	static int query(int l, int r, int x, int lef, int rit) {
		if (l > rit || r < lef) return -1;
		if (l >= lef && r <= rit) return seg[x];
		int mid = (l + r) / 2;
		return Math.max(query(l, mid, 2*x, lef, rit), query(mid+1, r, 2*x+1, lef, rit));
	}
	
	public static void main(String[] args) throws IOException {

		int Q = readInt(), P = readInt(), lastAns = 0, cnt = 0;
		for (int i=1; i<=Q; i++) {
			char c = readCharacter();
			if (c == 'A') {
				update(1, Q, 1, ++cnt, readInt() ^ lastAns);
			} else {
				int k = readInt() ^ lastAns;
				lastAns = query(1, Q, 1, cnt-k+1, cnt);
				System.out.println(lastAns);
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


	
	

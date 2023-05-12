
import java.io.*;
import java.util.*;

public class bsfast {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static final int MM = (int)1e6 + 5;
	static int[] arr = new int[MM], seg = new int[4*MM];
	
	static void build(int l, int r, int x) {
		if (l == r) seg[x] = arr[l];
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			
			seg[x] = Math.min(seg[2*x], seg[2*x+1]);
		}
	}
	
	static void update(int l, int r, int x, int ind, int v) {
		if (l == r) seg[x] = v;
		else {
			int mid = (l + r) / 2;
			if (ind <= mid) update(l, mid, 2*x, ind, v);
			else update(mid+1, r, 2*x+1, ind, v);
			
			seg[x] = Math.min(seg[2*x], seg[2*x+1]);
		}
	}
	
	static int query(int l, int r, int x, int lef, int rit, int k) {
		if (l > rit || r < lef) return -1;
		if (l >= lef && r <= rit) { // possible optimization? https://dmoj.ca/src/3623365
			if (seg[x] >= k) return -1;
			while (l != r) {
				int mid = (l + r) / 2;
				if (seg[2*x] < k) {
					x *= 2;
					r = mid;
				} else {
					x = 2*x + 1;
					l = mid + 1;
				}
			}
			
			return l;
		}
		
		int mid = (l + r) / 2;
		int ret = -1;
		
		if (seg[2*x] < k) ret = query(l, mid, 2*x, lef, rit, k);
		if (ret == -1) ret = query(mid+1, r, 2*x+1, lef, rit, k);
		
		return ret;
	}
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt(), lastAns = 0;
		
		for (int i=1; i<=N; i++) arr[i] = readInt();
		
		build(1, N, 1);
		

		
		for (int i=1; i<=Q; i++) {
			int c = readInt();
			
			if (c == 1) {
				int p = readInt() ^ lastAns, x = readInt() ^ lastAns;
				update(1, N, 1, p, x);
			}
			else {
				int l = readInt() ^ lastAns, r = readInt() ^ lastAns, k = readInt() ^ lastAns;
				lastAns = query(1, N, 1, l, r, k);
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


	
	


import java.io.*;
import java.util.*;

public class oly22practice28 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e6 + 5;
	static long[] a = new long[MN], seg = new long[3*MN], lzy = new long[3*MN];
	
	static void update(int l, int r, int x, int lef, int rit, int v) {
		push_down(l, r, x);
		if (l > rit || r < lef) return;
		else if (l >= lef && r <= rit){
			
			seg[x] += v * (r - l + 1);
			if (l != r) {
				lzy[2*x] += v;
				lzy[2*x+1] += v;
			}
			
		} else {
			int mid = (l + r) / 2;
			update(l, mid, 2*x, lef, rit, v);
			update(mid+1, r, 2*x+1, lef, rit, v);
			seg[x] = seg[2*x] + seg[2*x+1];
		}
		
	}
	
	static long query(int l, int r, int x, int ind) {
		push_down(l, r, x);
		if (l == r) return seg[x];
	
		int mid = (l + r) / 2;
		
		if (ind <= mid) return query(l, mid, 2*x, ind);
		else return query(mid+1, r, 2*x+1, ind);
	}
	
	static void push_down(int l, int r, int x) {
		if (lzy[x] == 0) return;
		
		seg[x] += lzy[x] * (r - l + 1);
		if (l != r) {
			lzy[2*x] += lzy[x];
			lzy[2*x+1] += lzy[x];
		}
		lzy[x] = 0;
		
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		
		for (int i=1; i<=Q; i++) {
			int c = readInt();
			
			if (c == 1) {
				int l = readInt(), r = readInt(), k = readInt();
				
				update(1, N, 1, l, r, k);
			} else {
				System.out.println(query(1, N, 1, readInt()));
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


	
	

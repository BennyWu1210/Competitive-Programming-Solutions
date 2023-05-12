
import java.io.*;
import java.util.*;

public class Dynamic_Range_Minimum_Test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] seg, arr;
	static int INF = (int)1e9;

	static void build() {
		
		int n = 1;
		
		while (n < arr.length) n *= 2;
		
		seg = new int[2 * n];
		Arrays.fill(seg, INF);
		
		build(0, 0, n);
	}
	
	static void build(int n, int l, int r) {
		if (r - l == 1) {
			if (l < arr.length) seg[n] = arr[l];
			
			return;
		}
		
		int m = (l + r) / 2;
		build(2*n+1, l, m);
		build(2*n+2, m, r);
		
		seg[n] = Math.min(seg[2*n+1], seg[2*n+2]);
	}
	
	static void update(int i, int val, int n, int lx, int rx) {
		if (rx - lx == 1) {
			seg[n] = val;
			return;
		}
		
		int m = (lx + rx) / 2;
		if (i < m) {
			update(i, val, 2*n+1, lx, m);
		}
		else {
			update(i, val, 2*n+2, m, rx);
		}
		
		seg[n] = Math.min(seg[2*n+1], seg[2*n+2]);
	}
	
	static int get(int l, int r, int n, int lx, int rx) {
		if (lx >= r || rx <= l) return INF;
		if (lx >= l && rx <= r) return seg[n];
		
		int m = (lx + rx) / 2;
		return Math.min(get(l, r, 2*n+1, lx, m), get(l, r, 2*n+2, m, rx));
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		arr = new int[N];
		
		for (int i=0; i<N; i++) arr[i] = readInt();
		
		build();
		
		for (int i=0; i<M; i++) {
			String[] input = br.readLine().split(" ");
			
			char a = input[0].charAt(0);
			int b = Integer.parseInt(input[1]), c = Integer.parseInt(input[2]);
			
			if (a == 'Q') {
				int ans = get(b, c+1, 0, 0, seg.length/2);
				System.out.println(ans);
			} else {
				update(b, c, 0, 0, seg.length/2);
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


	
	

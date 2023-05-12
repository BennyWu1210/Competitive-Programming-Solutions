
import java.io.*;
import java.util.*;

public class A_Inversion {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5 + 5;
	static int[] seg = new int[4*MM];
	static int n;
	
	static void update(int l, int r, int x, int ind) {
		if (l == r) seg[x] = 1;
		else {
			int mid = (l + r) / 2;
			
			if (ind <= mid) update(l, mid, 2*x, ind);
			else update(mid+1, r, 2*x+1, ind);
			
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static int query(int l, int r, int x, int lef, int rit) {
		if (l > rit || r < lef) return 0;
		if (l >= lef && r <= rit) return seg[x];
		
		int mid = (l + r) / 2;
		
		return query(l, mid, 2*x, lef, rit) + query(mid+1, r, 2*x+1, lef, rit);
		
	}
	
	public static void main(String[] args) throws IOException {

		n = readInt();
		for (int i=0; i<n; i++) {
			int cur = readInt();
			
			int ans = query(1, n, 1, cur, n);
			System.out.print(ans + " ");
			
			update(1, n, 1, cur);
			
		}
		System.out.println();
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


	
	

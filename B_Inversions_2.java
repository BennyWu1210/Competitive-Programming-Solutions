
import java.io.*;
import java.util.*;

public class B_Inversions_2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5 + 5;
	static int[] seg = new int[4*MM], arr, ans;
	
	static void build(int l, int r, int x) {
		if (l == r) seg[x] = 1;
		else {
			int mid = (l + r) / 2;
			
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static void update(int l, int r, int x, int ind) {
		if (l == r) seg[x] = 0;
		else {
			int mid = (l + r) / 2;
			
			if (ind <= mid) update(l, mid, 2*x, ind);
			else update(mid+1, r, 2*x+1, ind);
			
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static int query(int l, int r, int x, int k) {
		
		if (l == r) return l;
		
		int mid = (l + r) / 2;
		
		if (seg[2*x+1] > k) return query(mid+1, r, 2*x+1, k);
		else return query(l, mid, 2*x, k-seg[2*x+1]);
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		arr = new int[n];
		ans = new int[n];
		
		build(1, n, 1);
		
		for (int i=0; i<n; i++) arr[i] = readInt();
		
		for (int i=n-1; i>=0; i--) {
			int ind = query(1, n, 1, arr[i]);
			ans[i] = ind;
			update(1, n, 1, ind);
		}
		
		for (int a: ans) System.out.print(a + " ");
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


	
	

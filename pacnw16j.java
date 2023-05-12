import java.io.*;
import java.util.*;

public class pacnw16j {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static long[] seg;
	static long[][] lookup;
	static int[] mm;
	static long INF = (long)1e18 + 5;

	static void build(long[] arr) {
		int n = 1;

		while (n < arr.length) n *= 2;

		seg = new long[2 * n];
		Arrays.fill(seg, INF);

		build(0, 0, n, arr);
	}
	
	static void buildSparseTable(long[] arr) {
		int n = arr.length;
		lookup = new long[n+1][18];
		mm = new int[n+1];
		
		mm[0] = -1;
		for (int i=1; i<=arr.length; i++) {
			mm[i] = ((i & (i - 1)) == 0) ? mm[i-1] + 1 : mm[i-1];
			lookup[i][0] = arr[i-1];
		}
		
		for (int j = 1; j <= mm[n]; j++) {
			for (int i = 1; (i + (1 << j) - 1) <= n; i++) {
				lookup[i][j] = 
					Math.min(
						lookup[i][j-1], 
						lookup[i + (1 << (j - 1))][j - 1]
					);
			}
		}
		
		
	}
	
	static long query(int l, int r) {
		int j = mm[r - l + 1]; // precompute the length
		l ++;
		r ++;
		return Math.min(lookup[l][j], 
				lookup[r-(1<<j)+1][j]);
	}


	static void build(int ind, int li, int ri, long[] arr) {
		if (ri - li == 1) {
			if (li < arr.length) {
				seg[ind] = arr[li];
			}

			return;
		}

		int m = (li + ri) / 2;
		build(2*ind+1, li, m, arr);
		build(2*ind+2, m, ri, arr);

		seg[ind] = Math.min(seg[2*ind+1], seg[2*ind+2]);
	}

	static long get(int l, int r, int ind, int li, int ri) {
		if (li >= r || ri <= l) return INF;
		if (li >= l && ri <= r) return seg[ind];

		int m = (li + ri) / 2;
		long min1 = get(l, r, 2*ind+1, li, m);
		long min2 = get(l, r, 2*ind+2, m, ri);

		return Math.min(min1, min2);
	}

	// bsearch
	static int findNext(int l, int r, long val) {
		int li = l, ri = r-1, ind = -1;
		
		long temp = query(li, ri);
		if (temp > val) {
			return -1;
		}
		
		
		while (li <= ri) {
			int mid = (li + ri) / 2;
			if (query(li, ri) <= val) {
				ri = mid - 1;
				ind = mid;
			} else{
				li = mid + 1;
			}
		}

		return ind;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		long[] arr = new long[N];

		for (int i=0; i<N; i++) arr[i] = readLong();

		// build(arr); // build seg tree
		
		buildSparseTable(arr); // build sparse table


		for (int i=0; i<Q; i++) {
			long val = readLong();
			int l = readInt()-1, r = readInt();

			while (l < r && val > 0) {
				int next = findNext(l, r, val); // look for index of  next number smaller than "val"
				if (next == -1) {
					break; // break if no number in this range is smaller than "val"
				}
				l = next + 1;
				val %= arr[next]; // mod it
			}

			System.out.println(val);

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
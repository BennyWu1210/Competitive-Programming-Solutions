
import java.io.*;
import java.util.*;

public class First_element_at_least_X {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int MM = (int)1e5 + 5;
	static int n, m;
	static long[] arr = new long[MM], seg = new long[4*MM];

	static void build(int l, int r, int x) {
		if (l == r) seg[x] = arr[l];
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);

			seg[x] = Math.max(seg[2*x], seg[2*x+1]);
		}
	}

	static void update(int l, int r, int x, int ind, long v) {
		if (l == r) seg[x] = v;
		else {
			int mid = (l + r) / 2;

			if (ind <= mid) update(l, mid, 2*x, ind, v);
			else update(mid+1, r, 2*x+1, ind, v);

			seg[x] = Math.max(seg[2*x], seg[2*x+1]);
		}
	}

	static long query(int l, int r, int x, long v, int left) {
		if (r < left) return 0;
		if (l == r) {
			return l;
		}
		
		int mid = (l + r) / 2;
		
		long lefRes = 0, rigRes = 0;
		if (seg[2*x] >= v) lefRes = query(l, mid, 2*x, v, left);
		if (seg[2*x+1] >= v) rigRes = query(mid+1, r, 2*x+1, v, left); 
		
		if (lefRes != 0) return lefRes;
		else return rigRes;
	}


	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());

		build(1, n, 1);

		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());

			if (c == 1) {
				int ind = Integer.parseInt(st.nextToken()) + 1;
				long v = Long.parseLong(st.nextToken());
				update(1, n, 1, ind, v);
			}
			else {
				long val = Long.parseLong(st.nextToken());
				int ind = Integer.parseInt(st.nextToken()) + 1;
				System.out.println(query(1, n, 1, val, ind) - 1);
			}
		}
	}
	
	

}





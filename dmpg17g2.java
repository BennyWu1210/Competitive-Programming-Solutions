
import java.io.*;
import java.util.*;

public class dmpg17g2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5 + 5, INF = (int)1e9+5;;
	static int[] arr = new int[MM];
	static Node[] seg = new Node[4*MM];
	
	static class Node{
		long val, pre, suf, sum, maxV;
		
		public Node(long sum, long val, long pre, long suf, long maxV) {
			this.val = val;
			this.sum = sum;
			this.pre = pre;
			this.suf = suf;
			this.maxV = maxV;
		}
	}
	
	static void build(int l, int r, int x) {
		if (l == r) {
			long val = Math.max(0, arr[l]);
			seg[x] = new Node(arr[l], val, val, val, arr[l]);
			return;
		}
		int mid = (l + r) / 2;
		build(l, mid, 2*x);
		build(mid+1, r, 2*x+1);
		
		seg[x] = merge(seg[2*x], seg[2*x+1]);
	}
	
	static void update(int l, int r, int x, int ind, int v) {
		if (l == r) {
			long val = Math.max(0, v);
			seg[x] = new Node(v, val, val, val, v);
			return;
		}
		
		int mid = (l + r) / 2;
		if (mid <= ind) {
			update(l, mid, 2*x, ind, v);
		}
		else {
			update(mid+1, r, 2*x+1, ind, v);
		}
		
		seg[x] = merge(seg[2*x], seg[2*x+1]);
	}
	
	static Node query(int l, int r, int x, int lx, int rx) {
		if (lx > r || rx < l) return new Node(-INF, -INF, -INF, -INF, -INF);
		if (lx <= l && rx >= r) return seg[x];
		
		int mid = (l + r) / 2;
		Node left = query(l, mid, 2*x, lx, rx);
		Node right = query(mid+1, r, 2*x+1, lx, rx);
		
		return merge(left, right);
	}
	
	static Node merge(Node l, Node r) {

		Node res = new Node(-INF, -INF, -INF, -INF, -INF);

		res.sum = l.sum + r.sum;
		res.pre = Math.max(l.pre, l.sum + r.pre);
		res.suf = Math.max(r.suf, r.sum + l.suf);
		res.val = Math.max(l.suf + r.pre, Math.max(l.val, r.val));
		res.maxV = Math.max(l.maxV, r.maxV);
		
		return res;
	}
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		for (int i=1; i<=N; i++) arr[i] = readInt();
		
		build(1, N, 1);
		
		for (int i=0; i<Q; i++) {
			char c = readCharacter();
				
			if (c == 'S') {
				int ind = readInt(), x = readInt();
				update(1, N, 1, ind, x);
			}
			else if (c == 'Q') {
				int l = readInt(), r = readInt();
				Node res = query(1, N, 1, l, r);
				// System.out.println(res.maxV);
				System.out.println(Math.max(res.val, res.maxV));
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


	
	

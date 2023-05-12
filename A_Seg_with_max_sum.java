
import java.io.*;
import java.util.*;

public class A_Seg_with_max_sum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5+5;
	static final long MIN = Long.MIN_VALUE;
	static Node[] seg = new Node[4*MM]; 
	static long[] arr = new long[MM];
	static int n, m;
	
	static class Node{
		long pre, suf, sum, ans;
		
		public Node(long pre, long suf, long sum, long ans) {
			this.pre = pre;
			this.suf = suf;
			this.sum = sum;
			this.ans = ans;
		}
	}
	static void build(int l, int r, int x) {
		if (r == l) {
			long val  = Math.max(arr[l], 0);
			seg[x] = new Node(val, val, arr[l], val);
		}
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}
	
	static void update(int l, int r, int x, int ind, long v) {
		if (l == r) {
			long val  = Math.max(v, 0);
			seg[x] = new Node(val, val, v, val);
		}
		else {
			int mid = (l + r) / 2;
			
			if (ind <= mid) update(l, mid, 2*x, ind, v);
			else update(mid+1, r, 2*x+1, ind, v);
			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}
	
	static Node query(int l, int r, int i, int x, int y) {
		if (l > y || r < x) return new Node(MIN, MIN, MIN, MIN);
		if (l >= x && r <= y) return seg[x];
		
		int mid = (l + r) / 2;
		Node left = query(l, mid, 2*x, x, y);
		Node right = query(mid+1, r, 2*x+1, x, y);
		
		return merge(left, right);
	}
	
	static Node merge(Node l, Node r) {
		Node res = new Node(0, 0, 0, 0);
		
		res.pre = Math.max(l.sum + r.pre, l.pre);
		res.suf = Math.max(l.suf + r.sum, r.suf);
		res.sum = l.sum + r.sum;
		res.ans = Math.max(l.suf + r.pre, Math.max(l.ans, r.ans));
		
		return res;
		
	}
	public static void main(String[] args) throws IOException {

		n = readInt(); m = readInt();
		
		for (int i=1; i<=n; i++) arr[i] = readInt();
		
		build(1, n, 1);
		
		System.out.println(seg[1].ans);
		
		for (int i=0; i<m; i++) {
			
			int ind = readInt() + 1, v = readInt();
			
			update(1, n, 1, ind, v);
			
			System.out.println(seg[1].ans);
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


	
	

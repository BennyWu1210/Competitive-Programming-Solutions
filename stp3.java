
import java.io.*;
import java.util.*;

public class stp3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5 * 2 + 5, INF = (int)1e9;;
	static Node[] seg = new Node[4*MM];
	static long[] arr = new long[MM];
	
	static class Node{
		long v, pre, sum;
		
		public Node(long v, long pre, long sum) {
			this.v = v;
			this.pre = pre;
			this.sum = sum;
		}
	}
	
	static void build(int l, int r, int x) {
		if (l == r) {
			seg[x] = new Node(arr[l], arr[l], arr[l]);
		}
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}
	
	static void update(int l, int r, int x, int ind, long val) {
		if (l == r) {
			seg[x] = new Node(val, val, val);
		}
		else {
			int mid = (l + r) / 2;
			if (ind <= mid) update(l, mid, 2*x, ind, val);
			else update(mid+1, r, 2*x+1, ind, val);
			
			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}
	
	static Node query(int lx, int rx, int l, int r, int x) {
		if (l > rx || r < lx) return new Node(-INF, -INF, 0);
		if (l >= lx && r <= rx) return seg[x];
		
		int mid = (l + r) / 2;
		Node left = query(lx, rx, l, mid, 2*x);
		Node right = query(lx, rx, mid+1, r, 2*x+1);
		return merge(left, right);
	}
	
	static Node merge(Node a, Node b) {
		Node res = new Node(0, 0, 0);
		res.pre = Math.max(a.pre, a.sum + b.pre);
		res.v = Math.max(a.v, b.v);
		res.sum = a.sum + b.sum;
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		
		for (int i=1; i<=N; i++) {
			int v = readInt();
			arr[i] = v;
		}
		
		build(1, N, 1);
		
		
		for (int i=0; i<Q; i++) {
			char c = readCharacter();
			int x = readInt(), y = readInt();
			
			if (c == 'P') {
				System.out.println(query(x, y, 1, N, 1).pre);
			}
			else {
				arr[x] = y;
				update(1, N, 1, x, y);
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


	
	

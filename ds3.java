
import java.io.*;
import java.util.*;

public class ds3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e5 + 5, INF = Integer.MAX_VALUE;
	static int[] arr = new int[MM];
	static Node[] seg = new Node[4*MM];
	
	static class Node{
		int v, min, gcd, cnt;
		
		public Node(int v, int min, int gcd, int cnt) {
			this.v = v;
			this.min = min;
			this.gcd = gcd;
			this.cnt = cnt;
		}
		
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b); 
	}
	
	static void build(int l, int r, int x) {
		if (l == r) {
			seg[x] = new Node(arr[l], arr[l], arr[l], 1);
		}else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}
	
	static void update(int l, int r, int x, int ind, int v) {
		if (l == r) {
			seg[x] = new Node(v, v, v, 1);
		}else {
			int mid = (l + r) / 2;
			if (ind <= mid) update(l, mid, 2*x, ind, v);
			else update(mid+1, r, 2*x+1, ind, v);
			seg[x] = merge(seg[2*x], seg[2*x+1]);
		}
	}
	
	static Node query(int l, int r, int x, int lef, int rit) {
		if (l > rit || r < lef) return new Node(-1, INF, 0, 0);
		if (l >= lef && r <= rit) return seg[x];
		
		int mid = (l + r) / 2;
		
		return merge(query(l, mid, 2*x, lef, rit), query(mid+1, r, 2*x+1, lef, rit));
	}
	
	static Node merge(Node a, Node b) {
		Node res = new Node(0, 0, 0, 0);
		
		res.min = Math.min(a.min, b.min);
		res.gcd = gcd(a.gcd, b.gcd);
		
		if (a.gcd == res.gcd) res.cnt += a.cnt;
		if (b.gcd == res.gcd) res.cnt += b.cnt;
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		
		for (int i=1; i<=N; i++) arr[i] = readInt();
		
		build(1, N, 1);
		
		for (int i=1; i<=M; i++) {
			char c = readCharacter();
			
			if (c == 'C') {
				update(1, N, 1, readInt(), readInt());
			}
			else {
				Node res = query(1, N, 1, readInt(), readInt());
				if (c == 'M') {
					System.out.println(res.min);
				}
				else if (c == 'G') {
					System.out.println(res.gcd);
				}
				else {
					System.out.println(res.cnt);
				}
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


	
	

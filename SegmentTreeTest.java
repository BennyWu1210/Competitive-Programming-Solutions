
import java.io.*;
import java.util.*;

public class SegmentTreeTest {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = 100005, INF = (int)1e9;
	static Node[] seg = new Node[4*MM];
	static int[] arr = new int[MM];
	
	static class Node{
		int min, gcd, count;
		
		public Node(int min, int gcd, int count){
			this.count = count;
			this.min = min;
			this.gcd = gcd;
		}
	}
	
	static Node merge(Node a, Node b) {
		Node res = new Node(0, 0, 0);
		res.min = Math.min(a.min, b.min);
		res.gcd = gcd(a.gcd, b.gcd);
		
		if (res.gcd == a.gcd) res.count += a.count;
		if (res.gcd == b.gcd) res.count += b.count;
		
		return res;
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	
	static void build(int l, int r, int i) {
		if (l == r) {
			seg[i] = new Node(arr[l], arr[l], 1);
			return;
		}
		
		int mid = (l + r) / 2;
		build(l, mid, i*2);
		build(mid+1, r, i*2+1);
		seg[i] = merge(seg[i*2], seg[i*2+1]);
	}
	
	static void update(int l, int r, int x, int val, int i) {
		if (l == r) {
			seg[i] = new Node(val, val, 1);
			return;
		}
		int mid = (l + r) / 2;
		if (x <= mid) update(l, mid, x, val, i*2);
		else update(mid+1, r, x, val, i*2+1);
		
		seg[i] = merge(seg[i*2], seg[i*2+1]);
	}
	
	static Node query(int l, int r, int x, int y, int idx) {
		if (x > r || y < l) return new Node(INF, 0, 0);
		if (x <= l && y >= r) return seg[idx];
		
		int mid = (l + r) / 2;
		
		Node left = query(l, mid, x, y, idx*2);
		Node right = query(mid+1, r, x, y, idx*2+1);
		return merge(left, right);
		
		
	}
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		for (int i=1; i<=N; i++) arr[i] = readInt();
		
		build(1, N, 1);
		
		for (int i=0; i<M; i++) {
			char c = readCharacter();
			
			if (c == 'C') {
				int x = readInt(), v = readInt();
				update(1, N, x, v, 1);
			}
			else if (c == 'M') {
				int l = readInt(), r = readInt();
				System.out.println(query(1, N, l, r, 1).min);
			}
			else if (c == 'G') {
				int l = readInt(), r = readInt();
				System.out.println(query(1, N, l, r, 1).gcd);
			}
			else if (c == 'Q') {				
				int l = readInt(), r = readInt();
				System.out.println(query(1, N, l, r, 1).count);
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


	
	


import java.io.*;
import java.util.*;

public class mcco17p2 {

	static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MM = 2*(int)1e5 + 5, MIN = Integer.MIN_VALUE;
	static Node[] st = new Node[4*MM];
	static int N, Q, K;
	
	static class Node{
		long v, lzy;
		public Node(long v, long lzy){
			this.v = v; this.lzy = lzy;
		}
	}
	
	static void update(int l, int r, int x, int lef, int rit, long v) {
		push_down(l, r, x);
		if (l > rit || r < lef) return;
		if (l >= lef && r <= rit) {
			st[x].v += v;
			if (l != r) {
				st[2*x].lzy += v;
				st[2*x+1].lzy += v;
			}
			return;
		}
		
		int mid = (l + r) / 2;
		update(l, mid, 2*x, lef, rit, v);
		update(mid+1, r, 2*x+1, lef, rit, v);
		st[x].v = Math.max(st[2*x].v, st[2*x+1].v);
	}
	
	static long query(int l, int r, int x, int lef, int rit) {
		push_down(l, r, x);
		if (l > rit || r < lef) return MIN;
		if (l >= lef && r <= rit) return st[x].v;
		int mid = (l + r) / 2;
		return Math.max(query(l, mid, 2*x, lef, rit), query(mid+1, r, 2*x+1, lef, rit));
	}
	
	static void push_down(int l, int r, int x) {
		if (st[x].lzy == 0) return;
		st[x].v += st[x].lzy;
		if (l != r) {
			st[2*x].lzy += st[x].lzy;
			st[2*x+1].lzy += st[x].lzy;
		}
		st[x].lzy = 0;
	}
	
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), Q = readInt();
		
		for (int i=0; i<4*MM; i++) st[i] = new Node(0, 0);
		
		for (int i=0; i<Q; i++) {
			int c = readInt();
			if (c == 0) {
				int p = readInt() + 1, v = readInt();
				update(1, N, 1, Math.max(1, p - K + 1), p, v);
			}
			else {
				int l = readInt() + 1, r = readInt() + 1;
				System.out.println(query(1, N, 1, l, r));
			}
		}
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) {
			stk = new StringTokenizer(br.readLine());
		}
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
	
}


	
	


import java.io.*;
import java.util.*;

public class sac21ccp5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node{
		int par, tot, rank;
		
		public Node(int par, int tot, int rank) {
			this.par = par;
			this.tot = tot;
			this.rank = rank;
		}
	}
	
	static int MM = (int)1e5 + 5;
	static Node[] a = new Node[MM];
	
	static int find(int u) {
		if (a[u].par == u) {
			return u;
		}
		return a[u].par = find(a[u].par);
	}
	
	static void merge(int uu, int vv) {
		uu = find(uu);
		vv = find(vv);
		
		if (uu == vv) return;
		
		Node u = a[uu];
		Node v = a[vv];
		
		if (u.tot < v.tot) {
			u.par = v.par;
			v.tot += u.tot;
		}
		else {
			v.par = u.par;
			u.tot += v.tot;
		}
		

	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		
		for (int i=1; i<MM; i++) {
			a[i] = new Node(i, 1, 0);
		}
		
		for (int i=0; i<Q; i++) {
			int c = readInt();
			
			if (c == 1) {
				int u = readInt(), v = readInt();
				merge(u, v);
			}else {
				int u = readInt();
				System.out.println(a[find(u)].tot);
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


	
	
